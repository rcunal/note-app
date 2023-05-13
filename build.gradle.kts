// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:${Dependencies.androidPluginVersion}")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:${Dependencies.kotlinVersion}")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:${Dependencies.hiltVersion}")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:${Dependencies.navigationVersion}")
    }
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