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
    api("javax.inject:javax.inject:1")
    api("com.google.dagger:hilt-core:${Versions.hiltVersion}")
    kapt("com.google.dagger:hilt-compiler:${Versions.hiltVersion}")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
}