plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
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

    // For debugging UI
    debugImplementation(libs.androidx.ui.tooling.v120)

    // Coroutines for background tasks
    implementation(libs.kotlinx.coroutines.core.v152)
    implementation(libs.kotlinx.coroutines.android.v152)

    // Other dependencies
    implementation(libs.androidx.compose.bom.v20241000)
    implementation(libs.androidx.ui.v174)
    implementation(libs.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview.v174)
    implementation(libs.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v113)
    androidTestImplementation(libs.androidx.espresso.core.v340)
    androidTestImplementation(libs.androidx.compose.bom.v20241000)
    androidTestImplementation(libs.androidx.ui.test.junit4.v120)
    debugImplementation(libs.androidx.ui.test.manifest.v174)
    implementation(libs.androidx.material.icons.extended.v150)
}