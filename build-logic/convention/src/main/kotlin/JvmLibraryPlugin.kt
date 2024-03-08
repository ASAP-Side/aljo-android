import utils.configureKotlinJvm
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * 순수 JVM 라이브러리를 위한 플러그인 ex) domain
 * */
internal class JvmLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.jvm")
            }
            configureKotlinJvm()
        }
    }
}
