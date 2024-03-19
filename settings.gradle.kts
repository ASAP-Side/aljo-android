rootProject.name = "aljo-android"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://devrepo.kakao.com/nexus/content/groups/public/") // for kakaoLogin
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://devrepo.kakao.com/nexus/content/groups/public/") // for kakaoLogin
    }
}

// app
include(":app")

// core
include(":core:domain")
include(":core:data")
include(":core:design-system")
include(":core:remote")
include(":core:navigation")
//include(":core:local")
//include(":core:navigation")
//include(":core:ui")

// feature
include(":feature:login")
