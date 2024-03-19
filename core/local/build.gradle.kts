plugins {
    alias(libs.plugins.aljo.android.library)
}

android {
    namespace = "team.asap.aljo.local"
}

dependencies {
    implementation(libs.bundles.room)
}