plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.gms.google-services") version "4.4.2" // Specify the version if needed
    id("kotlin-android") // Include Kotlin if needed
    id("kotlin-kapt")
}


android {

    signingConfigs {
        create("release") {
            keyAlias = "key0" // Replace with your key alias
            keyPassword = "hello1" // Replace with your key password
            storeFile = file("C:\\Users\\dines\\Downloads\\experiment.jks") // Replace with the path to your keystore file
            storePassword = "hello" // Replace with your keystore password
        }
    }
    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = true// Set to true if you want to enable ProGuard
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

android {
    namespace = "com.example.experiment"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.experiment"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    // Jetpack Compose Dependencies
    implementation(libs.androidx.ui.v174)
    implementation(libs.androidx.ui.tooling.preview.v174)
    implementation(libs.material3)
    implementation(libs.androidx.lifecycle.viewmodel.compose.v240)
    implementation(libs.androidx.navigation.compose.v240alpha10)
    implementation(libs.androidx.constraintlayout.compose.v100alpha08)
    implementation(libs.androidx.core.ktx.v170)

    // Firebase Dependencies
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.auth.ktx)
    implementation(libs.play.services.maps)
    implementation(libs.maps)

    // For debugging UI
    debugImplementation(libs.androidx.ui.tooling.v120)

    // Coroutines for background tasks
    implementation(libs.kotlinx.coroutines.core.v152)
    implementation(libs.kotlinx.coroutines.android.v152)

    // OSMDroid and OSMBonusPack
    implementation("org.osmdroid:osmdroid-android:6.1.20") // Latest stable version
    implementation("com.github.MKergall:osmbonuspack:6.9.0") // Latest stable version

    // Additional libraries
    implementation("com.android.volley:volley:1.2.1")
    implementation("org.maplibre.gl:android-sdk:11.5.2") // Use MapLibre if needed

    // Testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v113)
    androidTestImplementation(libs.androidx.espresso.core.v340)
    androidTestImplementation(platform(libs.androidx.compose.bom.v20241000))
    androidTestImplementation(libs.androidx.ui.test.junit4.v120)
    debugImplementation(libs.androidx.ui.test.manifest.v174)

    // Fonts and Icons
    implementation(libs.androidx.material.icons.extended)
    implementation(libs.androidx.ui.text.google.fonts)
}
