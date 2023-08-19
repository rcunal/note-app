plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.noteapp.datasource.local"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
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
}

dependencies {
    // Room
    api("androidx.room:room-runtime:${Versions.roomVersion}")
    api("androidx.room:room-ktx:${Versions.roomVersion}")
    api("androidx.room:room-paging:${Versions.roomVersion}")
    kapt("androidx.room:room-compiler:${Versions.roomVersion}")

    // Hilt
    implementation("com.google.dagger:hilt-core:${Versions.hiltVersion}")
    kapt("com.google.dagger:hilt-compiler:${Versions.hiltVersion}")
}