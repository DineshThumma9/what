package com.example.experiment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthenticationViewModel : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _authState = MutableStateFlow<FirebaseUser?>(null)
    val authState: StateFlow<FirebaseUser?> = _authState

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun setErrorMessage(message: String) {
        _errorMessage.value = message
    }

    fun signIn(identifier: String, password: String) {
        viewModelScope.launch {
            // Check if identifier is an email or username
            val email = if (isEmail(identifier)) identifier else getEmailFromUsername(identifier)

            if (email != null) {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            _authState.value = auth.currentUser
                            _errorMessage.value = null
                        } else {
                            _authState.value = null
                            _errorMessage.value = task.exception?.message
                        }
                    }
            } else {
                _errorMessage.value = "Invalid username or email format."
            }
        }
    }

    fun signUp(email: String, password: String) {
        viewModelScope.launch {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        _authState.value = auth.currentUser
                        _errorMessage.value = null
                    } else {
                        _authState.value = null
                        _errorMessage.value = task.exception?.message
                    }
                }
        }
    }

    private fun isEmail(identifier: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(identifier).matches()
    }

    private fun getEmailFromUsername(username: String): String? {
        // Implement logic to retrieve email from username
        // This could involve querying your database or using a mapping from usernames to emails
        // For demonstration purposes, let's assume we return a dummy email for a specific username
        return when (username) {
            "testUser" -> "testuser@example.com" // Replace with actual logic
            else -> null
        }
    }
}
