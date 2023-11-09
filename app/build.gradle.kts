import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
}

android {
    compileSdk = Apps.compileSdk
    namespace = "team.asap.aljo"
    defaultConfig {
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk
        versionCode = Apps.versionCode
        versionName = Apps.versionName

        buildConfigField(
            "String",
            "KAKAO_NATIVE_APP_KEY",
            getValueFromLocalProperties("KAKAO_NATIVE_APP_KEY")
        )
    }

    compileOptions {
        sourceCompatibility = Apps.sourceCompat
        targetCompatibility = Apps.targetCompat
    }

    kotlinOptions {
        jvmTarget = Apps.jvmTarget
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(project(Modules.Presentation))
    implementation(project(Modules.Domain))
    implementation(project(Modules.Data))

    implementation(Dependencies.Login.Kakao)

    // Add Firebase Dependencies
    //implementation(platform(Dependencies.Firebase.Bom))

    implementation(Dependencies.Hilt.Android)
    kapt(Dependencies.Hilt.Kapt)

    implementation(Dependencies.Logging.Timber)
}

fun getValueFromLocalProperties(propertyKey: String): String {
    return gradleLocalProperties(rootDir).getProperty(propertyKey)
}