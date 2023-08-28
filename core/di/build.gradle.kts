plugins {
    id("noteapp.jvm.library")
    id("kotlin-kapt")
}

dependencies {
    api(libs.javax.inject)
    api(libs.hilt.core)
    kapt(libs.hilt.compiler)
    api(libs.kotlinx.coroutines.core)
}