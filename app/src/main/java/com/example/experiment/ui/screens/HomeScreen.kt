
package com.example.experiment.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.experiment.ui.theme.ExperimentTheme

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Home",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Safety Alert",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { /* TODO: Handle safety alert click */ },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Tap to send Safety Alert")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Your location and other details will be shared with your emergency contacts.",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* TODO: Turn on safety alert */ },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Turn on safety alert")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Ambulance Tracking",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Arriving in 5 minutes")
        Text(text = "Ambulance 1")

        Spacer(modifier = Modifier.height(16.dp))

        ClickableText(
            text = androidx.compose.ui.text.AnnotatedString("View all ambulances"),
            onClick = { /* TODO: Handle view all click */ },
            modifier = Modifier.align(Alignment.End)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Patient Status",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "In transit")
        Text(text = "Haley, age 7")

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Alerts",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Severe weather warning")
        Text(text = "Tornado warning until 10:00 PM")

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Home")
            Text(text = "Track")
            Text(text = "Diagnosis")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { /* TODO: Track functionality */ },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Track")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* TODO: Open Settings */ },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Settings")
        }
    }
}


@Composable
fun Home(){
    Box(modifier =  Modifier.fillMaxSize()){

    }
}


@Preview(showBackground = true)
@Composable
fun HomePreview(){
    ExperimentTheme {
        Home()
    }
}