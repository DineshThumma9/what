package com.example.experiment.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.DataArray
import androidx.compose.material.icons.filled.Feedback
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        // Wrapping in LazyColumn for scrollability
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            item {
                // Title row
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Settings",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 35.sp
                        ),
                        modifier = Modifier.padding(16.dp)
                    )

                    Icon(
                        imageVector = Icons.Outlined.Settings,
                        contentDescription = "Settings Icon", // Added content description
                        tint = Color.Black,
                        modifier = Modifier.size(60.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // User Section
                SectionTitle("User's")
                SettingsItem(
                    title = "Profile",
                    icon = Icons.Filled.Person,
                    onClick = { /* Navigate to profile editing screen */ }
                )
                SettingsItem(
                    title = "Security & Logins",
                    icon = Icons.Filled.Lock,
                    onClick = { /* Navigate to security and logins screen */ }
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Medical Section
                SectionTitle("Medical")
                SettingsItem(
                    title = "Emergency Contacts",
                    icon = Icons.Filled.Phone,
                    onClick = { /* Navigate to emergency contacts screen */ }
                )
                SettingsItem(
                    title = "Medical Receipts",
                    icon = Icons.Filled.Receipt,
                    onClick = { /* Navigate to medical receipts screen */ }
                )
                SettingsItem(
                    title = "Health Data Sharing",
                    icon = Icons.Filled.DataArray,
                    onClick = { /* Navigate to health data sharing screen */ }
                )

                Spacer(modifier = Modifier.height(16.dp))

                // App Section
                SectionTitle("App")
                SettingsItem(
                    title = "Notification Settings",
                    icon = Icons.Filled.Notifications,
                    onClick = { /* Navigate to notification settings screen */ }
                )
                SettingsItem(
                    title = "App Preferences",
                    icon = Icons.Filled.Settings,
                    onClick = { /* Navigate to app preferences screen */ }
                )
                SettingsItem(
                    title = "Feedback",
                    icon = Icons.Filled.Feedback,
                    onClick = { /* Navigate to feedback screen */ }
                )
                SettingsItem(
                    title = "About App",
                    icon = Icons.Filled.Info,
                    onClick = { /* Navigate to about app screen */ }
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Logout Button
                Button(
                    onClick = { handleLogout() },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Text("Logout", color = Color.White)
                }
            }
        }
    }
}

// Section title composable with consistent alignment
@Composable
fun SectionTitle(title: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp),
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth() // Ensure title is full width
        )
        Divider(modifier = Modifier.fillMaxWidth())
    }
}

// Settings item composable with proper alignment
@Composable
fun SettingsItem(title: String, icon: ImageVector, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(24.dp) // Ensure icons are consistently sized
            )
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)
            )
        }

        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
            modifier = Modifier.size(24.dp) // Right arrow size consistent
        )
    }
}

// Firebase logout logic
fun handleLogout() {
    FirebaseAuth.getInstance().signOut()
    // Handle additional actions after logout, e.g., navigate to login screen
}

@Preview(showBackground = true)
@Composable
fun PreviewSettingsPage() {
    SettingsScreen()
}
