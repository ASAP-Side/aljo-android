import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "team.asap.aljo.data"
    compileSdk = Apps.compileSdk
    defaultConfig {
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk
    }
    compileOptions {
        sourceCompatibility = Apps.sourceCompat
        targetCompatibility = Apps.targetCompat
    }
    kotlinOptions {
        jvmTarget = Apps.jvmTarget
    }
}

dependencies {
    kapt(Dependencies.Hilt.Kapt)
    kapt(Dependencies.Room.Compiler)
    implementation(project(Modules.Domain))
    implementation(Dependencies.Hilt.Android)
    implementation(Dependencies.Room.Core)
    implementation(Dependencies.Paging.Runtime)
    implementation(Dependencies.Kotlin.Coroutine)
    implementation(Dependencies.Logging.Timber)
    Dependencies.Network.forEach(::implementation)
}
