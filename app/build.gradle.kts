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
        kotlinCompilerExtensionVersion = Versions.composeCompilerVersion
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

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")

    androidTestImplementation("androidx.test.espresso:espresso-core:${Versions.espressoVersion}")
    androidTestImplementation("androidx.test.espresso:espresso-contrib:${Versions.espressoVersion}")
    debugImplementation("androidx.fragment:fragment-testing:${Versions.fragmentVersion}")
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:rules:1.5.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")

    androidTestImplementation("com.google.dagger:hilt-android-testing:${Versions.hiltVersion}")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}")

    implementation("com.google.dagger:hilt-android:${Versions.hiltVersion}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}")

    // Room
    implementation("androidx.room:room-runtime:${Versions.roomVersion}")
    implementation("androidx.room:room-ktx:${Versions.roomVersion}")
    implementation("androidx.room:room-paging:${Versions.roomVersion}")
    ksp("androidx.room:room-compiler:${Versions.roomVersion}")

    // Paging
    implementation("androidx.paging:paging-runtime-ktx:${Versions.pagingVersion}")

    // Navigation Component
    implementation("androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}")
    implementation("androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}")

    // KTX
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ktxVersion}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${Versions.ktxVersion}")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    //swipe layout
    implementation("com.chauthai.swipereveallayout:swipe-reveal-layout:1.4.1")

    implementation("com.github.bumptech.glide:glide:4.15.1") // TODO: will be removed after moving fragments
}