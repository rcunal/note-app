plugins {
    id("noteapp.android.library")
    id("kotlin-kapt")
}

android {
    namespace = "com.noteapp.note_details.data"
}

dependencies {
    implementation(project(":core:di"))
    implementation(project(":core:datasource:local"))
    implementation(project(":features:note_details:domain"))
    implementation(libs.javax.inject)
    implementation(libs.hilt.core)
    kapt(libs.hilt.compiler)
}