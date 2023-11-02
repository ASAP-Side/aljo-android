plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Apps.compileSdk
    namespace = "team.asap.aljo.app"
    defaultConfig {
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk
        versionCode = Apps.versionCode
        versionName = Apps.versionName
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
    implementation(project(Modules.Presentation))
    implementation(project(Modules.Domain))
    implementation(project(Modules.Data))
    implementation(Dependencies.AppCompat.Core)
    implementation(Dependencies.Hilt.Android)
    kapt(Dependencies.Hilt.Kapt)
}