plugins {
    alias(libs.plugins.aljo.android.library)
}

android {
    namespace = "team.asap.aljo.local"
}

dependencies {
    implementation(projects.core.data)

    implementation(libs.bundles.room)
}