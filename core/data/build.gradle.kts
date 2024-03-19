plugins {
    alias(libs.plugins.aljo.android.library)
    alias(libs.plugins.aljo.junit5)
}

android {
    namespace = "team.asap.aljo.data"
}

dependencies {
    implementation(projects.core.domain)
}
