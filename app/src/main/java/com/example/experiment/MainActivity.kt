package com.example.experiment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.experiment.ui.navigation.MainScreen
import com.example.experiment.ui.screens.SignUpScreen
import com.example.experiment.ui.theme.ExperimentTheme
import com.example.experiment.viewmodel.AuthenticationViewModel
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        val auth = FirebaseAuth.getInstance()
        val viewModel = AuthenticationViewModel()

        setContent {
            ExperimentTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    MainScreen( auth = auth)
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun Login(){
    ExperimentTheme {
        SignUpScreen(viewModel = AuthenticationViewModel() , navController =  rememberNavController() , auth =  FirebaseAuth.getInstance())
    }
}