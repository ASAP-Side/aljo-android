import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    alias(libs.plugins.aljo.android.library)
}

val properties = Properties().apply {
    load(rootProject.file("local.properties").inputStream())
}
android {
    namespace = "team.asap.aljo.remote"

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
    implementation(projects.core.data)

    implementation(libs.bundles.retrofit)
    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp.logging.interceptor)

}