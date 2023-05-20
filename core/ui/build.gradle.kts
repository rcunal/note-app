plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
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
    }
}

dependencies {
    api("androidx.constraintlayout:constraintlayout:2.1.4")
    api("androidx.appcompat:appcompat:1.6.1")
    api("androidx.core:core-ktx:1.10.1")
    api("androidx.fragment:fragment-ktx:${Dependencies.fragmentVersion}")
    api("com.google.android.material:material:1.9.0")
    implementation("com.github.bumptech.glide:glide:4.15.1")

    // Dagger Hilt
    api("com.google.dagger:hilt-android:${Dependencies.hiltVersion}")
    kapt("com.google.dagger:hilt-android-compiler:${Dependencies.hiltVersion}")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
}