import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.aljo.android.library)
}

android {
    namespace = "team.asap.aljo.remote"

    buildTypes {
        val aljoBaseUrl = gradleLocalProperties(rootDir).getProperty("ALJO_BASE_URL")
        getByName("release") {
            buildConfigField("String", "ALJO_BASE_URL", aljoBaseUrl)
        }
        getByName("debug") {
            buildConfigField("String", "ALJO_BASE_URL", aljoBaseUrl)
        }
    }
}

dependencies {
    implementation(projects.core.data)

    implementation(libs.bundles.retrofit)
    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp.logging.interceptor)
}