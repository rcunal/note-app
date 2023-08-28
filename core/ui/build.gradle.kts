plugins {
    id("noteapp.android.library")
    id("noteapp.android.library.compose")
    id("kotlin-kapt")
}

android {
    namespace = "com.noteapp.core.ui"

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    api(libs.androidx.constraintlayout)
    api(libs.androidx.appcompat)
    api(libs.androidx.core.ktx)
    api(libs.androidx.fragment.ktx)
    api(libs.material)
    implementation(libs.glide)

    // Navigation Component
    api(libs.androidx.navigation.fragment.ktx)
    api(libs.androidx.navigation.ui.ktx)

    implementation(libs.hilt.core)
    kapt(libs.hilt.compiler)
}