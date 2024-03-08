import com.android.build.gradle.BaseExtension
import utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

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

            dependencies {
                add("implementation", platform(libs.findLibrary("compose.bom").get()))
                add("implementation", libs.findBundle("compose").get())
            }
        }
}
