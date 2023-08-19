plugins {
    id("org.jetbrains.kotlin.jvm")
    id("kotlin-kapt")
    `java-library`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    api(libs.javax.inject)
    api(libs.hilt.core)
    kapt(libs.hilt.compiler)
    api(libs.kotlinx.coroutines.core)
}