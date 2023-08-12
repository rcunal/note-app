plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.noteapp.core.ui"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.composeCompilerVersion
    }
}

dependencies {
    api("androidx.constraintlayout:constraintlayout:2.1.4")
    api("androidx.appcompat:appcompat:1.6.1")
    api("androidx.core:core-ktx:1.10.1")
    api("androidx.fragment:fragment-ktx:${Dependencies.fragmentVersion}")
    api("com.google.android.material:material:1.9.0")
    implementation("com.github.bumptech.glide:glide:4.15.1")

    // Navigation Component
    api("androidx.navigation:navigation-fragment-ktx:${Dependencies.navigationVersion}")
    api("androidx.navigation:navigation-ui-ktx:${Dependencies.navigationVersion}")

    implementation("com.google.dagger:hilt-core:${Dependencies.hiltVersion}")
    kapt("com.google.dagger:hilt-compiler:${Dependencies.hiltVersion}")

    val composeBom = platform("androidx.compose:compose-bom:2023.08.00")
    api(composeBom)
    api("androidx.compose.material3:material3")
    api("androidx.compose.ui:ui-tooling-preview")
    debugApi("androidx.compose.ui:ui-tooling")

//    api("androidx.activity:activity-compose:1.7.3")
//    api("androidx.lifecycle:lifecycle-viewmodel-compose")
}