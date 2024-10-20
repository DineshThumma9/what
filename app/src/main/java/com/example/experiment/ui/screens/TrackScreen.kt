package com.example.experiment.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.experiment.R
import com.example.experiment.ui.componets.BottomNavigationBar

@Composable
fun NoAmbulanceScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(start=16.dp, end = 16.dp, top =16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            // Crossed Location Icon
            Image(
                   painter =  painterResource(id = R.drawable.ambulance_icon), // Replace with your actual icon
                contentDescription = "No Ambulance Icon",
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Message Text
            Text(
                text = "No Ambulance is booked yet",
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 20.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )


        }



        BottomNavigationBar(
            navController = rememberNavController(),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(0.dp)
                .background(color = Color.Red)
                .fillMaxWidth()// Align the BottomNavigationBar to the bottom
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNoAmbulanceScreen() {
    NoAmbulanceScreen()
}
