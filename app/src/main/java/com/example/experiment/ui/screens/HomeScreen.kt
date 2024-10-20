package com.example.experiment.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.experiment.R
import com.google.firebase.auth.FirebaseAuth


val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val fontName = GoogleFont("Anek Malayalam")

val customFontFamily = FontFamily(
    Font(googleFont = fontName, fontProvider = provider)
)

val Typo = Typography(

    bodyLarge = TextStyle(fontFamily = customFontFamily, fontSize = 32.sp, fontWeight = FontWeight.SemiBold),
    bodyMedium = TextStyle(fontFamily = customFontFamily, fontSize = 24.sp, fontWeight = FontWeight.Medium),
    bodySmall = TextStyle(
        fontFamily = customFontFamily,
        fontSize = 20.sp,
        fontWeight = FontWeight.Normal,
        color = Color.Black.copy(alpha = 0.5f) // Adjusting opacity to 50%
    )

)
@Composable
fun HomeScreen(auth: FirebaseAuth, navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        // Use LazyColumn to make the entire screen scrollable
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                 // Reserve space for the BottomNavigationBar
        ) {
            item { TopBar() }

            item { Spacer(modifier = Modifier.height(24.dp)) }

            item { GreetingText() }

            item { Spacer(modifier = Modifier.height(24.dp)) }

            item { SafetyAlert() }

            item { Spacer(modifier = Modifier.height(24.dp)) }

            item { AmbulanceTracking() }

            item { Spacer(modifier = Modifier.height(32.dp)) }

            item { PatientStatus() }

            item { Spacer(modifier = Modifier.height(32.dp)) }

            item { AlertsSection() }
        }

        // Extended Floating Action Button - Ensure it's aligned above the BottomNavigationBar
        ExtendedFloatingActionButton(
            text = { Text("Book an Ambulance") },
            onClick = { navController.navigate("register") }, // Corrected navigation
            icon = {
                Icon(Icons.Default.LocalHospital, contentDescription = "Book Ambulance")
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 80.dp, end = 16.dp), // Padding to avoid bottom nav overlap
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White
        )

//        // Bottom Navigation Bar - Aligned at the bottom of the Box
//        BottomNavigationBar(
//            navController = navController,
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//                .padding(0.dp)// Align the BottomNavigationBar to the bottom
//        )
    }
}


@Composable
fun TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Sanjeevani",
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold
        )
        Image(
            painter = painterResource(id = R.drawable.img), // replace with your profile image
            contentDescription = "Profile",
            modifier = Modifier
                .size(100.dp)
                .border(width = 5.dp, color = Color.Green, shape = CircleShape) // Light green with 50% opacity
                .clip(CircleShape)
        )
    }
}

@Composable
fun GreetingText() {

    Row( modifier =  Modifier.fillMaxWidth().padding(16.dp))
    {
        Text(text = "Hi, User", style = MaterialTheme.typography.titleLarge)
    }

}
@Composable
fun SafetyAlert() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(
                color = Color(0xFFFC6A6A), // Fill with the background color (FC6A6A)
                shape = RoundedCornerShape(15.dp) // Rounded corners
            )
            .border(
                width = 1.dp, // Stroke width
                color = Color(0xFFC85757), // Stroke color (C85757)
                shape = RoundedCornerShape(15.dp) // Apply the same rounding to the stroke
            )
            .shadow(
                elevation = 6.dp, // Drop shadow for elevation
                shape = RoundedCornerShape(15.dp) // Shadow conforms to rounded corners
            )
            .drawBehind {
                // Apply background blur effect here (if you want to simulate a blur)
                drawRect(Color.Transparent)
            }
            .padding(16.dp) // Padding inside the box
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Safety Alert",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
                )
                Text(
                    text = "Your safety has been verified.",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "We've sent your location to the police.",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.siren_icon),
                contentDescription = "Safety Alert",
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.Bottom)
            )
        }
    }
}

@Composable
fun AmbulanceTracking() {
    Column {
        Text(
            text = "Ambulance Tracking",
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 8.dp, bottom = 6.dp) // Reduced padding
        )

        // Horizontal Divider
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth() // Make it take full width
                .padding(vertical = 8.dp), // Reduced vertical padding to connect visually
            thickness = 2.dp,
            color = Color.Gray // Change color if desired
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically // Align icons to the center
        ) {
            // Column for Icons
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, // Center align icons
                modifier = Modifier.weight(1f) // Ensure it takes equal space
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ambulance_icon),
                    contentDescription = "Ambulance Icon",
                    modifier = Modifier.size(60.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Icon(
                    painter = painterResource(id = R.drawable.medical_bag_png),
                    contentDescription = "Medical Bag Icon",
                    modifier = Modifier.size(60.dp)
                )
            }

            // Column for Text
            Column(
                modifier = Modifier
                    .weight(3f) // Adjust the weight to take more space than icons
                    .align(Alignment.CenterVertically) // Ensure text aligns center with icons
            ) {
                Text(
                    text = "Ambulance ETA",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 4.dp) // Optional: add spacing
                )
                Text(
                    text = "Location: 17th & Valencia",
                    style = MaterialTheme.typography.bodySmall
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Ambulance Status",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 4.dp) // Optional: add spacing
                )
                Text(
                    text = "Paramedics are on the way to your location",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}@Composable
fun PatientStatus() {
    Column {
        Text(
            text = "Patient Status",
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp) // Reduced padding
        )

        // Horizontal Divider
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth() // Make it take full width
                .padding(vertical = 8.dp),
            thickness = 2.dp,
            color = Color.Gray // Change color if desired
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically // Align icons to the center
        ) {
            // Column for Icons
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, // Center align icons
                modifier = Modifier.weight(1f) // Ensure it takes equal space
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.heart_png),
                    contentDescription = "Heart Rate",
                    modifier = Modifier.size(60.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Icon(
                    painter = painterResource(id = R.drawable.blood_png),
                    contentDescription = "Oxygen Level",
                    modifier = Modifier.size(60.dp)
                )
            }

            // Column for Text
            Column(
                modifier = Modifier
                    .weight(3f) // Adjust the weight to take more space than icons
                    .align(Alignment.CenterVertically) // Ensure text aligns center with icons
            ) {
                Text(
                    text = "Heart Rate",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 4.dp) // Optional: add spacing
                )
                Text(
                    text = "Normal: 60-100 bpm",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Current: 110 bpm",
                    style = MaterialTheme.typography.bodySmall
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Oxygen Level",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 4.dp) // Optional: add spacing
                )
                Text(
                    text = "Normal: 95-100%",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Current: 96%",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
fun AlertsSection() {
    Column(modifier = Modifier.padding(vertical = 16.dp)) { // Increased overall padding
        Text(
            text = "Alerts",
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 8.dp) // Reduced bottom padding to bring closer to the divider
        )

        // Horizontal Divider
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp), // Padding below the divider
            thickness = 2.dp,
            color = Color.Gray
        )

        // Row for alerts and icon
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "High-priority alert",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "Your heart rate is unusually high.",
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Alert Icon",
                modifier = Modifier.size(48.dp)
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
fun PreviewHomeScreen() {
    MaterialTheme(typography = Typo) {
        HomeScreen(auth = FirebaseAuth.getInstance(), navController = rememberNavController())
    }
}

@Composable
fun MainScreenWithEFAB(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ExtendedFloatingActionButton(
            text = { Text("Book an Ambulance") },
            onClick = { navController.navigate("patientRegistration") },
            icon = {
                Icon(Icons.Default.LocalHospital, contentDescription = "Book Ambulance")
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 80.dp, end = 16.dp),
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreenWithEFAB() {

    MaterialTheme(typography = Typo) {
        MainScreenWithEFAB(navController = rememberNavController())

    }
}
