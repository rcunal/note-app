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
    implementation("javax.inject:javax.inject:1")
    implementation("com.google.dagger:hilt-core:${Dependencies.hiltVersion}")
    kapt("com.google.dagger:hilt-compiler:${Dependencies.hiltVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
}