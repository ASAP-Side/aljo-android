plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Apps.compileSdk
    namespace = "team.asap.aljo.presentation"
    defaultConfig {
        minSdk = Apps.minSdk
    }

    compileOptions {
        sourceCompatibility = Apps.sourceCompat
        targetCompatibility = Apps.targetCompat
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compiler.Compose
    }

    kotlinOptions {
        jvmTarget = Apps.jvmTarget
        freeCompilerArgs += listOf(
            "-P",
            "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=$rootDir/report/compose-metrics"
        )
        freeCompilerArgs += listOf(
            "-P",
            "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=$rootDir/report/compose-metrics"
        )
    }
}
dependencies {
    kapt(Dependencies.Hilt.Kapt)
    implementation(project(Modules.Domain))
    implementation(Dependencies.Hilt.Android)
    implementation(Dependencies.AppCompat.Core)
    implementation(Dependencies.Kotlin.Coroutine)
    implementation(Dependencies.Kotlin.ImmutableCollections)
    Dependencies.Compose.core.forEach(::implementation)
    Dependencies.Compose.sub.forEach(::implementation)
}