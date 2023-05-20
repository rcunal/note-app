plugins {
    id("com.android.application")
    kotlin("android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs")
    id("kotlin-parcelize")
}

android {
    compileSdk = 33
    namespace = "com.task.noteapp"

    defaultConfig {
        applicationId = "com.task.noteapp"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.task.noteapp.NoteAppTestRunner"
    }

    kapt {
        arguments {
            arg("room.schemaLocation", "$projectDir/schemas")
        }
    }

    buildTypes {
        getByName("release") {
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

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":core:di"))
    implementation(project(":core:datasource:local"))

    implementation(project(":features:home:domain"))
    implementation(project(":features:home:data"))

    implementation(project(":features:note_details:domain"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Dependencies.kotlinVersion}")
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.espresso:espresso-core:${Dependencies.espressoVersion}")
    androidTestImplementation("androidx.test.espresso:espresso-contrib:${Dependencies.espressoVersion}")
    androidTestImplementation("androidx.test.espresso.idling:idling-concurrent:${Dependencies.espressoVersion}")
    debugImplementation("androidx.test.espresso:espresso-idling-resource:${Dependencies.espressoVersion}")
    debugImplementation("androidx.fragment:fragment-testing:${Dependencies.fragmentVersion}")
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:rules:1.5.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.15.1")

    // Dagger Hilt
    implementation("com.google.dagger:hilt-android:${Dependencies.hiltVersion}")
    kapt("com.google.dagger:hilt-android-compiler:${Dependencies.hiltVersion}")
    kapt("androidx.hilt:hilt-compiler:1.0.0")

    androidTestImplementation("com.google.dagger:hilt-android-testing:${Dependencies.hiltVersion}")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:${Dependencies.hiltVersion}")

    // Room
    implementation("androidx.room:room-runtime:${Dependencies.roomVersion}")
    implementation("androidx.room:room-ktx:${Dependencies.roomVersion}")
    implementation("androidx.room:room-paging:${Dependencies.roomVersion}")
    kapt("androidx.room:room-compiler:${Dependencies.roomVersion}")

    // Paging
    implementation("androidx.paging:paging-runtime-ktx:${Dependencies.pagingVersion}")

    // Navigation Component
    implementation("androidx.navigation:navigation-fragment-ktx:${Dependencies.navigationVersion}")
    implementation("androidx.navigation:navigation-ui-ktx:${Dependencies.navigationVersion}")

    // KTX
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Dependencies.ktxVersion}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${Dependencies.ktxVersion}")
    // Fragment
    implementation("androidx.fragment:fragment-ktx:${Dependencies.fragmentVersion}")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    //swipe layout
    implementation("com.chauthai.swipereveallayout:swipe-reveal-layout:1.4.1")
}