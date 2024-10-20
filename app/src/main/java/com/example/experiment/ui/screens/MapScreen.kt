package com.example.experiment.ui.screens

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Polyline

@Composable
fun MapScreen(navController: NavHostController) {
    val context = LocalContext.current

    // Use SharedPreferences directly instead of PreferenceManager
    val sharedPrefs: SharedPreferences = context.getSharedPreferences("osmdroid_prefs", Context.MODE_PRIVATE)
    DisposableEffect(Unit) {
        Configuration.getInstance().load(context, sharedPrefs)
        onDispose {
            Configuration.getInstance().save(context, sharedPrefs)
        }
    }

    val mapView: MapView = remember { MapView(context) }

    // Keep a reference to the polyline
    var polyline by remember { mutableStateOf<Polyline?>(null) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // OSM MapView
        AndroidView(factory = {
            mapView.apply {
                setTileSource(org.osmdroid.tileprovider.tilesource.TileSourceFactory.MAPNIK)
                setMultiTouchControls(true)
                controller.setZoom(12.0)
                controller.setCenter(GeoPoint(17.3616, 78.4747)) // Charminar
            }
        }, modifier = Modifier
            .weight(1f)
            .fillMaxSize())

        // Draw route from Charminar to Gachibowli Stadium
        polyline = DrawRoute(mapView, polyline)

        MapDetails(mapView)
//
//      //  BottomNavigationBar(
//      //      navController = navController,
//            modifier = Modifier
//                .align(Alignment.CenterHorizontally)
//                .padding(0.dp)
//        )
    }
}

@Composable
fun DrawRoute(mapView: MapView?, existingPolyline: Polyline?): Polyline? {
    // Define route coordinates
    val routePoints = listOf(
        GeoPoint(17.3616, 78.4747),  // Charminar
        GeoPoint(17.4401, 78.3446)   // Gachibowli Stadium
    )

    // Remove existing polyline if it exists
    existingPolyline?.let {
        mapView?.overlayManager?.remove(it)
    }

    // Create a new Polyline and add it to the map
    val newPolyline = Polyline().apply {
        setPoints(routePoints)
        outlinePaint.color = 0xFFFF0000.toInt() // Red color
        outlinePaint.strokeWidth = 5f // Width of the line
    }

    mapView?.overlayManager?.add(newPolyline) // Add the new polyline to the map
    return newPolyline // Return the new polyline reference
}

@Composable
fun MapDetails(mapView: MapView?) {
    var isTracking by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Ambulance ETA: 15 minutes", style = MaterialTheme.typography.headlineSmall)
        Text("Ambulance Status: On Route", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            isTracking = !isTracking

            // Change camera perspective when tracking is toggled
            val targetPoint = if (isTracking) GeoPoint(17.4401, 78.3446) else GeoPoint(17.3616, 78.4747)

            mapView?.controller?.animateTo(targetPoint, if (isTracking) 14.0 else 12.0, 3000)
        }) {
            Text(if (isTracking) "Stop Tracking" else "Track Ambulance")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewMapScreen() {
    // Provide a dummy NavController for preview
    val navController = rememberNavController()
    MapScreen(navController as NavHostController)
}