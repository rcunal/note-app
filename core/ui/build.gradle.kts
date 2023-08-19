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

//    api(libs.androidx.activity.compose)
//    api(platform(libs.androidx.compose.bom))
//    api(libs.androidx.compose.ui)
//    api(libs.androidx.compose.ui.graphics)
//    api(libs.androidx.compose.ui.tooling.preview)
//    api(libs.androidx.compose.material3)
//    debugApi(libs.androidx.compose.ui.tooling)
//    debugApi(libs.androidx.compose.ui.testManifest)
//    api(libs.androidx.lifecycle.runtimeCompose)
//    api(libs.androidx.lifecycle.viewModelCompose)
}