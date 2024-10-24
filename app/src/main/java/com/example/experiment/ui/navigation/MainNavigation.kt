package com.example.experiment.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.experiment.ui.componets.BottomNavigationBar
import com.example.experiment.ui.screens.AmbulanceConfirmationScreen
import com.example.experiment.ui.screens.ChatScreen
import com.example.experiment.ui.screens.HomeScreen
import com.example.experiment.ui.screens.MapScreen
import com.example.experiment.ui.screens.PatientRegistrationForm
import com.example.experiment.ui.screens.SettingsScreen
import com.example.experiment.ui.screens.SignInScreen
import com.example.experiment.ui.screens.SignUpScreen
import com.example.experiment.viewmodel.AuthenticationViewModel
import com.google.firebase.auth.FirebaseAuth

@Composable
fun MainScreen(auth: FirebaseAuth) {
    // Create NavController using rememberNavController for managing navigation
    val navController = rememberNavController()

    // Use the viewModel() function to get the instance of AuthenticationViewModel
    val authViewModel = AuthenticationViewModel()

    // Get the current backstack entry's route
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Scaffold provides the basic layout structure
    Scaffold(
        bottomBar = {
            // Conditionally show the BottomNavigationBar except on the SignIn and SignUp screens
            if (currentRoute != Screens.Login.route && currentRoute != Screens.SignUp.route) {
                BottomNavigationBar(navController = navController)
            }
        }
    ) { innerPadding ->
        // NavHost is used to manage the navigation between screens
        NavHost(
            navController = navController,
            startDestination = Screens.Login.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screens.Home.route) {
                HomeScreen(auth = auth, navController = navController)
            }
            composable(Screens.RegistrationForm.route) {
                PatientRegistrationForm(navController = navController)
            }
            composable(Screens.AmbulanceConformed.route) {
                AmbulanceConfirmationScreen(navController = navController)
            }
            composable(Screens.MapScreen.route) {
                MapScreen(navController = navController)
            }
            composable(Screens.ChatScreen.route) {
                ChatScreen()
            }
            composable(Screens.Settings.route) {
                SettingsScreen()
            }
            composable(Screens.Login.route) {
                SignInScreen(viewModel = authViewModel, navController = navController, auth = auth)
            }
            composable(Screens.SignUp.route) {
                SignUpScreen(viewModel = authViewModel, navController = navController, auth = auth)
            }
        }
    }
}
