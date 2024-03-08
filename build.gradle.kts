buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://devrepo.kakao.com/nexus/content/groups/public/") // for kakaoLogin
    }

    dependencies {
        classpath(libs.kotlin.gradleplugin)
        classpath(libs.hilt.plugin)
        classpath(libs.agp)
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.kapt) apply false
    alias(libs.plugins.dagger.hilt) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.junit5) apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}