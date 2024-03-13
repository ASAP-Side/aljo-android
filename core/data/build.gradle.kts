import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    alias(libs.plugins.aljo.android.library)
    alias(libs.plugins.aljo.junit5)
}

val properties = Properties().apply {
    load(rootProject.file("local.properties").inputStream())
}

android {
    namespace = "team.asap.aljo.data"

    buildTypes {
        getByName("release") {
            buildConfigField(
                "String",
                "ALJO_BASE_URL",
                properties.getProperty("ALJO_BASE_URL")
            )
        }
        getByName("debug") {
            buildConfigField(
                "String",
                "ALJO_BASE_URL",
                properties.getProperty("ALJO_BASE_URL")
            )
        }
    }
}

dependencies {
    // module
    implementation(projects.core.domain)

    // library
    implementation(libs.bundles.retrofit)
    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.security)
    // test
    testImplementation(libs.mockk)
    testImplementation(libs.kotlin.coroutines.test)
    testImplementation(libs.mockk.webserver)
}
