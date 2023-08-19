plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("com.google.devtools.ksp")
}

android {
    compileSdk = 34
    namespace = "com.task.noteapp"

    defaultConfig {
        applicationId = "com.task.noteapp"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "com.task.noteapp.NoteAppTestRunner"

        ksp {
            arg("room.schemaLocation", "$projectDir/schemas")
        }
    }



    buildTypes {
        debug {
            isDebuggable = true
            applicationIdSuffix = ".debug"
        }
        release {
            isDebuggable = true
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
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
        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
        kotlinCompilerExtensionVersion = libs.findVersion("androidxComposeCompiler").get().toString()
    }
}

dependencies {
    implementation(project(":core:di"))
    implementation(project(":core:ui"))
    implementation(project(":core:domain"))
    implementation(project(":core:datasource:local"))

    implementation(project(":features:home:ui"))
    implementation(project(":features:home:domain"))
    implementation(project(":features:home:data"))

    implementation(project(":features:note_details:domain"))
    implementation(project(":features:note_details:data"))
    implementation(project(":features:note_details:ui"))
    implementation(project(":features:note_details:shared"))

    implementation(libs.kotlin.stdlib)
    implementation(libs.material)
    testImplementation(libs.junit4)
    testImplementation(libs.kotlinx.coroutines.test)

    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.espresso.contrib)
    debugImplementation(libs.androidx.fragment.testing)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.androidx.test.rules)
    androidTestImplementation(libs.androidx.junit)

    androidTestImplementation(libs.hilt.android.testing)
    kaptAndroidTest(libs.hilt.android.compiler)

    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // Room
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    implementation(libs.androidx.room.paging)
    ksp(libs.room.compiler)

    // Paging
    implementation(libs.androidx.paging.runtime.ktx)

    // Navigation Component
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // KTX
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Coroutines
    implementation(libs.kotlinx.coroutines.android)

    //swipe layout
    implementation(libs.swipe.reveal.layout)

    implementation(libs.glide) // TODO: will be removed after moving fragments
}