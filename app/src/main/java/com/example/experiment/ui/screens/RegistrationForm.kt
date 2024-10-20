//package com.example.experiment.ui.screens
//
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Cake
//import androidx.compose.material.icons.filled.Dangerous
//import androidx.compose.material.icons.filled.Height
//import androidx.compose.material.icons.filled.LocalHospital
//import androidx.compose.material.icons.filled.Map
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material.icons.filled.Phone
//import androidx.compose.material.icons.filled.Wc
//import androidx.compose.material3.Button
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateListOf
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import androidx.navigation.compose.rememberNavController
//import com.example.experiment.ui.navigation.Screens
//import com.example.experiment.ui.theme.ExperimentTheme
//
//@Composable
//fun PatientRegistrationForm(navController: NavController) {
//    var patientName by remember { mutableStateOf("") }
//    var age by remember { mutableStateOf("") }
//    var gender by remember { mutableStateOf("") }
//    var countryCode by remember { mutableStateOf("") }
//    var phoneNumber by remember { mutableStateOf("") }
//    var country by remember { mutableStateOf("") }
//    var state by remember { mutableStateOf("") }
//    var area by remember { mutableStateOf("") }
//    var pincode by remember { mutableStateOf("") }
//    var emergencyType by remember { mutableStateOf("") }
//    var additionalInfo by remember { mutableStateOf("") }
//    var paymentMode by remember { mutableStateOf("") }
//    var allergies by remember { mutableStateOf("") }
//    var weight by remember { mutableStateOf("") }
//    var height by remember { mutableStateOf("") }
//    var bloodGroup by remember { mutableStateOf("") }
//    var preferredHospital by remember { mutableStateOf("") }
//
//    // Suggestions for emergency type
//    val suggestions = remember { mutableStateListOf("Cardiac", "Accident", "Breathing Issues", "Other") }
//
//    LazyColumn(
//        modifier = Modifier
//            .padding(16.dp)
//            .fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        item {
//            Text(
//                text = "Request an Ambulance",
//                style = MaterialTheme.typography.displaySmall,
//                fontSize = 24.sp,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp),
//                textAlign = androidx.compose.ui.text.style.TextAlign.Center
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//        }
//
//        // Patient Name
//        item {
//            OutlinedTextField(
//                value = patientName,
//                onValueChange = { patientName = it },
//                label = { Text("Patient Name") },
//                leadingIcon = { Icon(Icons.Filled.Person, contentDescription = null) },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                shape = RoundedCornerShape(24.dp),
//                colors = TextFieldDefaults.colors(
//                    focusedContainerColor = Color.White,
//                    unfocusedContainerColor = Color.White,
//                    focusedIndicatorColor = Color.Blue,
//                    unfocusedIndicatorColor = Color.Gray
//                )
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//        }
//
//        // Age
//        item {
//            OutlinedTextField(
//                value = age,
//                onValueChange = { age = it },
//                label = { Text("Age") },
//                leadingIcon = { Icon(Icons.Filled.Cake, contentDescription = null) },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                shape = RoundedCornerShape(24.dp),
//                colors = TextFieldDefaults.colors(
//                    focusedContainerColor = Color.White,
//                    unfocusedContainerColor = Color.White,
//                    focusedIndicatorColor = Color.Blue,
//                    unfocusedIndicatorColor = Color.Gray
//                ),
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//        }
//
//        // Gender
//        item {
//            OutlinedTextField(
//                value = gender,
//                onValueChange = { gender = it },
//                label = { Text("Gender") },
//                leadingIcon = { Icon(Icons.Filled.Wc, contentDescription = null) },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                shape = RoundedCornerShape(24.dp),
//                colors = TextFieldDefaults.colors(
//                    focusedContainerColor = Color.White,
//                    unfocusedContainerColor = Color.White,
//                    focusedIndicatorColor = Color.Blue,
//                    unfocusedIndicatorColor = Color.Gray
//                )
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//        }
//
//        // Phone Number (Country Code + Number)
//        item {
//            Row(modifier = Modifier.fillMaxWidth()) {
//                OutlinedTextField(
//                    value = countryCode,
//                    onValueChange = { countryCode = it },
//                    label = { Text("Code") },
//                    leadingIcon = { Icon(Icons.Filled.Map, contentDescription = null) },
//                    modifier = Modifier
//                        .weight(1f)
//                        .padding(8.dp),
//                    shape = RoundedCornerShape(24.dp),
//                    colors = TextFieldDefaults.colors(
//                        focusedContainerColor = Color.White,
//                        unfocusedContainerColor = Color.White,
//                        focusedIndicatorColor = Color.Blue,
//                        unfocusedIndicatorColor = Color.Gray
//                    ),
//                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
//                )
//                OutlinedTextField(
//                    value = phoneNumber,
//                    onValueChange = { phoneNumber = it },
//                    label = { Text("Phone Number") },
//                    leadingIcon = { Icon(Icons.Filled.Phone, contentDescription = null) },
//                    modifier = Modifier
//                        .weight(2f)
//                        .padding(8.dp),
//                    shape = RoundedCornerShape(24.dp),
//                    colors = TextFieldDefaults.colors(
//                        focusedContainerColor = Color.White,
//                        unfocusedContainerColor = Color.White,
//                        focusedIndicatorColor = Color.Blue,
//                        unfocusedIndicatorColor = Color.Gray
//                    ),
//                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
//                )
//            }
//            Spacer(modifier = Modifier.height(8.dp))
//        }
//
//        // Address (Country, State, Area, Pincode)
//        item {
//            Row(modifier = Modifier.fillMaxWidth()) {
//                OutlinedTextField(
//                    value = country,
//                    onValueChange = { country = it },
//                    label = { Text("Country") },
//                    modifier = Modifier
//                        .weight(1f)
//                        .padding(8.dp),
//                    shape = RoundedCornerShape(24.dp),
//                    colors = TextFieldDefaults.colors(
//                        focusedContainerColor = Color.White,
//                        unfocusedContainerColor = Color.White,
//                        focusedIndicatorColor = Color.Blue,
//                        unfocusedIndicatorColor = Color.Gray
//                    )
//                )
//                OutlinedTextField(
//                    value = state,
//                    onValueChange = { state = it },
//                    label = { Text("State") },
//                    modifier = Modifier
//                        .weight(1f)
//                        .padding(8.dp),
//                    shape = RoundedCornerShape(24.dp),
//                    colors = TextFieldDefaults.colors(
//                        focusedContainerColor = Color.White,
//                        unfocusedContainerColor = Color.White,
//                        focusedIndicatorColor = Color.Blue,
//                        unfocusedIndicatorColor = Color.Gray
//                    )
//                )
//            }
//            Row(modifier = Modifier.fillMaxWidth()) {
//                OutlinedTextField(
//                    value = area,
//                    onValueChange = { area = it },
//                    label = { Text("Area") },
//                    modifier = Modifier
//                        .weight(2f)
//                        .padding(8.dp),
//                    shape = RoundedCornerShape(24.dp),
//                    colors = TextFieldDefaults.colors(
//                        focusedContainerColor = Color.White,
//                        unfocusedContainerColor = Color.White,
//                        focusedIndicatorColor = Color.Blue,
//                        unfocusedIndicatorColor = Color.Gray
//                    )
//                )
//                OutlinedTextField(
//                    value = pincode,
//                    onValueChange = { pincode = it },
//                    label = { Text("Pincode") },
//                    modifier = Modifier
//                        .weight(1f)
//                        .padding(8.dp),
//                    shape = RoundedCornerShape(24.dp),
//                    colors = TextFieldDefaults.colors(
//                        focusedContainerColor = Color.White,
//                        unfocusedContainerColor = Color.White,
//                        focusedIndicatorColor = Color.Blue,
//                        unfocusedIndicatorColor = Color.Gray
//                    ),
//                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//                )
//            }
//            Spacer(modifier = Modifier.height(8.dp))
//        }
//
//        // Allergies
//        item {
//            OutlinedTextField(
//                value = allergies,
//                onValueChange = { allergies = it },
//                label = { Text("Allergies") },
//                leadingIcon = { Icon(Icons.Filled.Dangerous, contentDescription = null) },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                shape = RoundedCornerShape(24.dp),
//                colors = TextFieldDefaults.colors(
//                    focusedContainerColor = Color.White,
//                    unfocusedContainerColor = Color.White,
//                    focusedIndicatorColor = Color.Blue,
//                    unfocusedIndicatorColor = Color.Gray
//                )
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//        }
//
//        // Height
//        item {
//            OutlinedTextField(
//                value = height,
//                onValueChange = { height = it },
//                label = { Text("Height") },
//                leadingIcon = { Icon(Icons.Filled.Height, contentDescription = null) },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                shape = RoundedCornerShape(24.dp),
//                colors = TextFieldDefaults.colors(
//                    focusedContainerColor = Color.White,
//                    unfocusedContainerColor = Color.White,
//                    focusedIndicatorColor = Color.Blue,
//                    unfocusedIndicatorColor = Color.Gray
//                )
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//        }
//
//        // Weight
//        item {
//            OutlinedTextField(
//                value = weight,
//                onValueChange = { weight = it },
//                label = { Text("Weight") },
//                leadingIcon = { Icon(Icons.Filled.LocalHospital, contentDescription = null) },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                shape = RoundedCornerShape(24.dp),
//                colors = TextFieldDefaults.colors(
//                    focusedContainerColor = Color.White,
//                    unfocusedContainerColor = Color.White,
//                    focusedIndicatorColor = Color.Blue,
//                    unfocusedIndicatorColor = Color.Gray
//                )
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//        }
//
//        // List of blood groups ranked by prevalence
//        val bloodGroupSuggestions = listOf("O+", "A+", "B+", "AB+", "O-", "A-", "B-", "AB-")
//
//        // Blood Group Field with Dropdown
//        item {
//            OutlinedTextField(
//                value = bloodGroup,
//                onValueChange = { bloodGroup = it },
//                label = { Text("Blood Group") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                shape = RoundedCornerShape(24.dp),
//                colors = TextFieldDefaults.colors(
//                    focusedContainerColor = Color.White,
//                    unfocusedContainerColor = Color.White,
//                    focusedIndicatorColor = Color.Blue,
//                    unfocusedIndicatorColor = Color.Gray
//                )
//            )
//
//            // Show blood group suggestions as the user types
//            if (bloodGroup.isNotEmpty()) {
//                SuggestionsDropdown(
//                    query = bloodGroup,
//                    suggestions = bloodGroupSuggestions,
//                    onSuggestionSelected = { selectedGroup -> bloodGroup = selectedGroup }
//                )
//            }
//            Spacer(modifier = Modifier.height(8.dp))
//        }
//
//        // Preferred Hospital
//        item {
//            OutlinedTextField(
//                value = preferredHospital,
//                onValueChange = { preferredHospital = it },
//                label = { Text("Preferred Hospital") },
//                leadingIcon = { Icon(Icons.Filled.LocalHospital, contentDescription = null) },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                shape = RoundedCornerShape(24.dp),
//                colors = TextFieldDefaults.colors(
//                    focusedContainerColor = Color.White,
//                    unfocusedContainerColor = Color.White,
//                    focusedIndicatorColor = Color.Blue,
//                    unfocusedIndicatorColor = Color.Gray
//                )
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//        }
//
//        // Emergency Type with suggestions
//        item {
//            OutlinedTextField(
//                value = emergencyType,
//                onValueChange = { emergencyType = it },
//                label = { Text("Type of Emergency") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                shape = RoundedCornerShape(24.dp),
//                colors = TextFieldDefaults.colors(
//                    focusedContainerColor = Color.White,
//                    unfocusedContainerColor = Color.White,
//                    focusedIndicatorColor = Color.Blue,
//                    unfocusedIndicatorColor = Color.Gray
//                )
//            )
//
//            // Show suggestions when typing
//            if (emergencyType.isNotEmpty()) {
//                SuggestionsDropdown(
//                    query = emergencyType,
//                    suggestions = suggestions,
//                    onSuggestionSelected = { emergencyType = it }
//                )
//            }
//
//            Spacer(modifier = Modifier.height(8.dp))
//        }
//
//        // Additional Info, Payment Mode
//        item {
//            OutlinedTextField(
//                value = additionalInfo,
//                onValueChange = { additionalInfo = it },
//                label = { Text("Additional Info") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                shape = RoundedCornerShape(24.dp),
//                colors = TextFieldDefaults.colors(
//                    focusedContainerColor = Color.White,
//                    unfocusedContainerColor = Color.White,
//                    focusedIndicatorColor = Color.Blue,
//                    unfocusedIndicatorColor = Color.Gray
//                )
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//        }
//
//        item {
//            Button(
//                onClick = {navController.navigate(Screens.AmbulanceConformed.route)},
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp)
//            ) {
//                Text(text = "Submit")
//            }
//        }
//    }
//}
//
//@Composable
//fun SuggestionsDropdown(query: String, suggestions: List<String>, onSuggestionSelected: (String) -> Unit) {
//    LazyColumn {
//        items(suggestions.filter { it.contains(query, ignoreCase = true) }) { suggestion ->
//            Text(
//                text = suggestion,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clickable { onSuggestionSelected(suggestion) }
//                    .padding(8.dp)
//            )
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun PatientRegistrationFormPreview() {
//    ExperimentTheme {
//        val navController = rememberNavController()
//        PatientRegistrationForm(navController)
//    }
//}
//
//
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Wc
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.coerceAtMost
import androidx.compose.ui.unit.coerceIn
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.experiment.ui.navigation.Screens
import com.example.experiment.ui.theme.ExperimentTheme

@Composable
fun PatientRegistrationForm(navController: NavController) {
    // State declarations
    var patientName by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var countryCode by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }
    var area by remember { mutableStateOf("") }
    var pincode by remember { mutableStateOf("") }
    var emergencyType by remember { mutableStateOf("") }
    var additionalInfo by remember { mutableStateOf("") }
    var paymentMode by remember { mutableStateOf("") }
    var allergies by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var bloodGroup by remember { mutableStateOf("") }
    var preferredHospital by remember { mutableStateOf("") }

    // Screen size calculations
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    // Dynamic sizing calculations
    val horizontalPadding = (screenWidth * 0.04f).coerceAtMost(32.dp)
    val verticalPadding = (screenHeight * 0.02f).coerceAtMost(16.dp)
    val titleSize = (screenWidth * 0.06f).coerceIn(18.dp, 28.dp).value.sp
    val labelSize = (screenWidth * 0.04f).coerceIn(14.dp, 16.dp).value.sp

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = horizontalPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Spacer(modifier = Modifier.height(verticalPadding))
            Text(
                text = "Request an Ambulance",
                fontSize = titleSize,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = verticalPadding),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displaySmall
            )
        }

        // Basic Information Section
        item {
            ResponsiveTextField(
                value = patientName,
                onValueChange = { patientName = it },
                label = "Patient Name",
                icon = { Icon(Icons.Filled.Person, contentDescription = null) },
                labelSize = labelSize
            )

            ResponsiveTextField(
                value = age,
                onValueChange = { age = it },
                label = "Age",
                icon = { Icon(Icons.Filled.Cake, contentDescription = null) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                labelSize = labelSize
            )

            ResponsiveTextField(
                value = gender,
                onValueChange = { gender = it },
                label = "Gender",
                icon = { Icon(Icons.Filled.Wc, contentDescription = null) },
                labelSize = labelSize
            )
        }

        // Contact Information Section
        item {
            AdaptivePhoneSection(
                countryCode = countryCode,
                onCountryCodeChange = { countryCode = it },
                phoneNumber = phoneNumber,
                onPhoneNumberChange = { phoneNumber = it },
                screenWidth = screenWidth,
                labelSize = labelSize
            )
        }

        // Address Section
        item {
            AdaptiveAddressSection(
                country = country,
                onCountryChange = { country = it },
                state = state,
                onStateChange = { state = it },
                area = area,
                onAreaChange = { area = it },
                pincode = pincode,
                onPincodeChange = { pincode = it },
                screenWidth = screenWidth,
                labelSize = labelSize
            )
        }

        // Medical Information Section
        item {
            ResponsiveTextField(
                value = allergies,
                onValueChange = { allergies = it },
                label = "Allergies",
                icon = { Icon(Icons.Filled.Dangerous, contentDescription = null) },
                labelSize = labelSize
            )

            AdaptiveMeasurementsSection(
                height = height,
                onHeightChange = { height = it },
                weight = weight,
                onWeightChange = { weight = it },
                screenWidth = screenWidth,
                labelSize = labelSize
            )

            ResponsiveBloodGroupField(
                bloodGroup = bloodGroup,
                onBloodGroupChange = { bloodGroup = it },
                labelSize = labelSize
            )

            ResponsiveTextField(
                value = preferredHospital,
                onValueChange = { preferredHospital = it },
                label = "Preferred Hospital",
                icon = { Icon(Icons.Filled.LocalHospital, contentDescription = null) },
                labelSize = labelSize
            )
        }

        // Emergency Information Section
        item {
            EmergencySection(
                emergencyType = emergencyType,
                onEmergencyTypeChange = { emergencyType = it },
                additionalInfo = additionalInfo,
                onAdditionalInfoChange = { additionalInfo = it },
                paymentMode = paymentMode,
                onPaymentModeChange = { paymentMode = it },
                labelSize = labelSize
            )
        }

        // Submit Button
        item {
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate(Screens.AmbulanceConformed.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height((screenHeight * 0.06f).coerceAtLeast(48.dp))
                    .padding(horizontal = horizontalPadding)
            ) {
                Text(
                    text = "Submit",
                    fontSize = labelSize
                )
            }
            Spacer(modifier = Modifier.height(verticalPadding))
        }
    }
}

@Composable
private fun ResponsiveTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    icon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    labelSize: TextUnit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, fontSize = labelSize) },
        leadingIcon = icon,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(24.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Blue,
            unfocusedIndicatorColor = Color.Gray
        ),
        keyboardOptions = keyboardOptions
    )
}

@Composable
private fun AdaptivePhoneSection(
    countryCode: String,
    onCountryCodeChange: (String) -> Unit,
    phoneNumber: String,
    onPhoneNumberChange: (String) -> Unit,
    screenWidth: Dp,
    labelSize: TextUnit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (screenWidth < 600.dp) Arrangement.Center else Arrangement.Start
    ) {
        ResponsiveTextField(
            value = countryCode,
            onValueChange = onCountryCodeChange,
            label = "Code",
            icon = { Icon(Icons.Filled.Map, contentDescription = null) },
            modifier = Modifier.weight(1f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            labelSize = labelSize
        )
        Spacer(modifier = Modifier.width(8.dp))
        ResponsiveTextField(
            value = phoneNumber,
            onValueChange = onPhoneNumberChange,
            label = "Phone Number",
            icon = { Icon(Icons.Filled.Phone, contentDescription = null) },
            modifier = Modifier.weight(2f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            labelSize = labelSize
        )
    }
}

@Composable
private fun AdaptiveAddressSection(
    country: String,
    onCountryChange: (String) -> Unit,
    state: String,
    onStateChange: (String) -> Unit,
    area: String,
    onAreaChange: (String) -> Unit,
    pincode: String,
    onPincodeChange: (String) -> Unit,
    screenWidth: Dp,
    labelSize: TextUnit
) {
    val isCompact = screenWidth < 600.dp

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if (isCompact) Alignment.CenterHorizontally else Alignment.Start
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = if (isCompact) Arrangement.Center else Arrangement.SpaceBetween
        ) {
            ResponsiveTextField(
                value = country,
                onValueChange = onCountryChange,
                label = "Country",
                modifier = Modifier.weight(1f),
                labelSize = labelSize
            )
            Spacer(modifier = Modifier.width(8.dp))
            ResponsiveTextField(
                value = state,
                onValueChange = onStateChange,
                label = "State",
                modifier = Modifier.weight(1f),
                labelSize = labelSize
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = if (isCompact) Arrangement.Center else Arrangement.SpaceBetween
        ) {
            ResponsiveTextField(
                value = area,
                onValueChange = onAreaChange,
                label = "Area",
                modifier = Modifier.weight(2f),
                labelSize = labelSize
            )
            Spacer(modifier = Modifier.width(8.dp))
            ResponsiveTextField(
                value = pincode,
                onValueChange = onPincodeChange,
                label = "Pincode",
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                labelSize = labelSize
            )
        }
    }
}

@Composable
private fun AdaptiveMeasurementsSection(
    height: String,
    onHeightChange: (String) -> Unit,
    weight: String,
    onWeightChange: (String) -> Unit,
    screenWidth: Dp,
    labelSize: TextUnit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (screenWidth < 600.dp) Arrangement.Center else Arrangement.SpaceBetween
    ) {
        ResponsiveTextField(
            value = height,
            onValueChange = onHeightChange,
            label = "Height",
            icon = { Icon(Icons.Filled.Height, contentDescription = null) },
            modifier = Modifier.weight(1f),
            labelSize = labelSize
        )
        Spacer(modifier = Modifier.width(8.dp))
        ResponsiveTextField(
            value = weight,
            onValueChange = onWeightChange,
            label = "Weight",
            icon = { Icon(Icons.Filled.LocalHospital, contentDescription = null) },
            modifier = Modifier.weight(1f),
            labelSize = labelSize
        )
    }
}

@Composable
private fun ResponsiveBloodGroupField(
    bloodGroup: String,
    onBloodGroupChange: (String) -> Unit,
    labelSize: TextUnit
) {
    val bloodGroupSuggestions = listOf("O+", "A+", "B+", "AB+", "O-", "A-", "B-", "AB-")

    Column(modifier = Modifier.fillMaxWidth()) {
        ResponsiveTextField(
            value = bloodGroup,
            onValueChange = onBloodGroupChange,
            label = "Blood Group",
            labelSize = labelSize
        )

        if (bloodGroup.isNotEmpty()) {
            SuggestionsDropdown(
                query = bloodGroup,
                suggestions = bloodGroupSuggestions,
                onSuggestionSelected = onBloodGroupChange
            )
        }
    }
}

@Composable
private fun EmergencySection(
    emergencyType: String,
    onEmergencyTypeChange: (String) -> Unit,
    additionalInfo: String,
    onAdditionalInfoChange: (String) -> Unit,
    paymentMode: String,
    onPaymentModeChange: (String) -> Unit,
    labelSize: TextUnit
) {
    val emergencySuggestions = remember { listOf("Cardiac", "Accident", "Breathing Issues", "Other") }
    val paymentModes = remember { listOf("Cash", "Card", "Insurance", "Other") }

    Column(modifier = Modifier.fillMaxWidth()) {
        ResponsiveTextField(
            value = emergencyType,
            onValueChange = onEmergencyTypeChange,
            label = "Type of Emergency",
            labelSize = labelSize
        )

        if (emergencyType.isNotEmpty()) {
            SuggestionsDropdown(
                query = emergencyType,
                suggestions = emergencySuggestions,
                onSuggestionSelected = onEmergencyTypeChange
            )
        }

        ResponsiveTextField(
            value = additionalInfo,
            onValueChange = onAdditionalInfoChange,
            label = "Additional Info",
            labelSize = labelSize
        )

        ResponsiveTextField(
            value = paymentMode,
            onValueChange = onPaymentModeChange,
            label = "Payment Mode",
            labelSize = labelSize
        )

        if (paymentMode.isNotEmpty()) {
            SuggestionsDropdown(
                query = paymentMode,
                suggestions = paymentModes,
                onSuggestionSelected = onPaymentModeChange
            )
        }
    }
}


@Composable
fun SuggestionsDropdown(query: String, suggestions: List<String>, onSuggestionSelected: (String) -> Unit) {
    LazyColumn {
        items(suggestions.filter { it.contains(query, ignoreCase = true) }) { suggestion ->
            Text(
                text = suggestion,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onSuggestionSelected(suggestion) }
                    .padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PatientRegistrationFormPreview() {
    ExperimentTheme {
        val navController = rememberNavController()
        PatientRegistrationForm(navController)
    }
}