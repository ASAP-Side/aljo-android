@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.aljo.android.library)
    alias(libs.plugins.aljo.junit5)
}

android {
    namespace = "team.asap.aljo.navigation"
}

dependencies {
    implementation(libs.navigation.compose)
    // test
    testImplementation(libs.mockk)
    testImplementation(libs.kotlin.coroutines.test)
    testImplementation(libs.mockk.webserver)
}