// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version Versions.Essential.Gradle apply false
    id("com.android.library") version Versions.Essential.Gradle apply false
    id("org.jetbrains.kotlin.android") version Versions.Kotlin.Core apply false
    id("org.jetbrains.kotlin.jvm") version Versions.Kotlin.Core apply false
    id("org.jetbrains.kotlin.kapt") version Versions.Kotlin.Core apply false
    id("com.google.dagger.hilt.android") version Versions.Jetpack.Hilt apply false
    id("com.google.gms.google-services") version Versions.Firebase.GoogleServices apply false
}