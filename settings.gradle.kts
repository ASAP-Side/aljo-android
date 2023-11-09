pluginManagement {
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

rootProject.name = "aljo-android"
include(
    ":app",
    ":data",
    ":domain",
    ":presentation",
)
