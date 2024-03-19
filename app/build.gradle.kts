import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.aljo.android.application)
    alias(libs.plugins.aljo.android.compose)
}

android {
    namespace = "team.asap.aljo"

    packaging {
        resources.excludes.add("META-INF/LICENSE*")
    }

    defaultConfig {
        applicationId = "team.asap.aljo"
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.appVersion.get()

        val kakaoNativeAppKey = gradleLocalProperties(rootDir).getProperty("KAKAO_NATIVE_APP_KEY")
        buildConfigField("String", "KAKAO_NATIVE_APP_KEY", kakaoNativeAppKey)

        manifestPlaceholders["KAKAO_NATIVE_APP_KEY"] = kakaoNativeAppKey
    }
}

dependencies {
    // core
    implementation(projects.core.domain)
    implementation(projects.core.data)
    implementation(projects.core.designSystem)
    implementation(projects.core.remote)
    implementation(projects.core.local)

    // feature
    implementation(projects.feature.login)

    // library
    implementation(libs.startup)
    implementation(libs.kakao.login)
    implementation(libs.lifecycle)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3.compose)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}
