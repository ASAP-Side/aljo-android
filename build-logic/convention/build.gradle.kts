plugins {
    `kotlin-dsl`
}

group = "team.asap.aljo.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.agp)
    compileOnly(libs.kotlin.gradleplugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    val pluginClasses = listOf(
        "android.application" to "AndroidApplicationPlugin",
        "android.feature" to "AndroidFeaturePlugin",
        "android.compose" to "AndroidComposePlugin",
        "android.hilt" to "AndroidHiltPlugin",
        "android.library" to "AndroidLibraryPlugin",
        "android.test" to "AndroidTestPlugin",
        "junit5" to "JUnit5Plugin",
        "jvm.library" to "JvmLibraryPlugin",
    )

    plugins {
        pluginClasses.forEach { pluginClass ->
            pluginRegister(pluginClass)
        }
    }
}

fun NamedDomainObjectContainer<PluginDeclaration>.pluginRegister(data: Pair<String, String>) {
    val (pluginName, className) = data
    register(pluginName) {
        id = "aljo.$pluginName"
        implementationClass = className
    }
}