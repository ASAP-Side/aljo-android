import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import utils.libs

internal class AndroidComposePlugin : Plugin<Project> {
    override fun apply(target: Project) =
        with(target) {
            extensions.getByType<BaseExtension>().apply {
                buildFeatures.apply {
                    compose = true
                }
                composeOptions {
                    kotlinCompilerExtensionVersion =
                        libs.findVersion("composeCompiler").get().toString()
                }
            }

            tasks.withType<KotlinCompile>().configureEach {
                kotlinOptions {
                    freeCompilerArgs += listOf(
                        "-P",
                        "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=$rootDir/report/compose-metrics"
                    )
                    freeCompilerArgs += listOf(
                        "-P",
                        "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=$rootDir/report/compose-metrics"
                    )
                }
            }

            dependencies {
                add("implementation", platform(libs.findLibrary("compose.bom").get()))
                add("implementation", libs.findBundle("compose").get())
            }
        }
}
