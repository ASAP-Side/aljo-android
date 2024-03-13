import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin
import utils.libs

internal class AndroidFeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply<AndroidLibraryPlugin>()

            dependencies {
                add("implementation", project(":core:domain"))
                add("implementation", project(":core:design-system"))
                add("implementation", libs.findLibrary("core.ktx").get())
                add("implementation", libs.findLibrary("appcompat").get())
                add("implementation", libs.findBundle("lifecycle").get())
                add("implementation", libs.findLibrary("material").get())
                add("testImplementation", kotlin("test"))
            }
        }
    }
}
