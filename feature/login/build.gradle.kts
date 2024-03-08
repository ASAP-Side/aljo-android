import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.aljo.android.feature)
    alias(libs.plugins.aljo.android.compose)
}

android {
    namespace = "team.asap.aljo.login"

}

dependencies {
    implementation(projects.core.domain)

}
