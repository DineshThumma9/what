package com.example.experiment.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.experiment.ui.theme.ExperimentTheme


@Composable
fun SignUpScreen() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }
    var termsAccepted by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // Center everything vertically
    ) {
        Text(
            text = "Sign Up", // Updated text
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 40.sp, fontWeight = FontWeight.Bold), // Bolder and updated style
            modifier = Modifier.padding(horizontal = 8.dp).padding(bottom = 4.dp).fillMaxWidth()// Reduced space between title and name field
        )

        // Name field
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            placeholder = { Text("Enter your name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp ),
            shape = RoundedCornerShape(16.dp) // Rounded corners
        )

        // Email field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            placeholder = { Text("Enter your email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
            shape = RoundedCornerShape(16.dp) // Rounded corners
        )

        // Phone Number field
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Phone Number") },
            placeholder = { Text("Enter your phone number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
            shape = RoundedCornerShape(16.dp) // Rounded corners
        )

        // Password field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            placeholder = { Text("Password") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = if (passwordVisible) "Hide password" else "Show password",
                        tint = MaterialTheme.colorScheme.primary // Updated tint color
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
            shape = RoundedCornerShape(16.dp) // Rounded corners
        )

        // Confirm Password field
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password") },
            placeholder = { Text("Confirm Password") },
            visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                    Icon(
                        imageVector = if (confirmPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = if (confirmPasswordVisible) "Hide confirm password" else "Show confirm password",
                        tint = MaterialTheme.colorScheme.primary // Updated tint color
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
            shape = RoundedCornerShape(16.dp) // Rounded corners
        )

        // Checkbox for Terms & Conditions
        TermsAndConditions(termsAccepted = termsAccepted, onCheckedChange = { termsAccepted = it })

        // Sign Up Button
        Button(
            onClick = { /* Handle Sign Up */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
            shape = RoundedCornerShape(24.dp) // Rounded corners
        ) {
            Text("Sign Up")
        }

        // Sign In Button
        TextButton(
            onClick = { /* Handle Sign In */ },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp) // Rounded corners
        ) {
            Text("Sign In")
        }
    }
}

@Composable
fun TermsAndConditions(termsAccepted: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Checkbox(
            checked = termsAccepted,
            onCheckedChange = onCheckedChange
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text("By creating an account, you agree to our Terms of Service and Privacy Policy.")
    }
}

