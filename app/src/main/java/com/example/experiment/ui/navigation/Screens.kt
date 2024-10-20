package com.example.experiment.ui.navigation




sealed class Screens(val route: String) {
   data object Home : Screens("home")
   data object Login : Screens("signin")
    data object SignUp : Screens("signup")
    data object Tracking : Screens("tracking")
    data object ChatScreen : Screens("ai_diagnosis")
    data object Settings : Screens("settings")
    data object AmbulanceTrackerScreen : Screens("ambtracker")
    data object  RegistrationForm : Screens("register")
    data object  AmbulanceConformed : Screens("Conformed")
    data  object  MapScreen : Screens("map")

}
