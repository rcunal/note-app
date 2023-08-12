buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:${Dependencies.androidPluginVersion}")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:${Dependencies.kotlinVersion}")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:${Dependencies.hiltVersion}")
    }
}

plugins {
    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}