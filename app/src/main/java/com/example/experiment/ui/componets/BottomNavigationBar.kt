package com.example.experiment.ui.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.experiment.ui.navigation.Screens

@Composable
fun BottomNavigationBar(navController: NavHostController, modifier: Modifier = Modifier) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry.value?.destination?.route

    NavigationBar(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color.White),
        containerColor = Color.Transparent
    ) {
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Outlined.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = currentDestination == Screens.Home.route,
            onClick = { navController.navigate(Screens.Home.route) }
        )
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Outlined.Place, contentDescription = "Map") },
            label = { Text("Map") },
            selected = currentDestination == Screens.MapScreen.route,
            onClick = { navController.navigate(Screens.MapScreen.route) }
        )
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Outlined.Favorite, contentDescription = "AI Diagnosis") },
            label = { Text("AI Diagnosis") },
            selected = currentDestination == Screens.ChatScreen.route,
            onClick = { navController.navigate(Screens.ChatScreen.route) }
        )
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Outlined.Settings, contentDescription = "Settings") },
            label = { Text("Settings") },
            selected = currentDestination == Screens.Settings.route,
            onClick = { navController.navigate(Screens.Settings.route) }
        )
    }
}
