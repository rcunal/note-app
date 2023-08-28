plugins {
    id("noteapp.android.library")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.noteapp.home.ui"

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":core:di"))
    implementation(project(":core:ui"))
    implementation(project(":core:domain"))
    implementation(project(":core:datasource:local"))
    implementation(project(":features:home:domain"))

    implementation(project(":features:note_details:shared"))

    implementation(libs.swipe.reveal.layout)
    implementation(libs.androidx.paging.runtime.ktx)

    kapt(libs.hilt.android.compiler)
    implementation(libs.hilt.android)
}