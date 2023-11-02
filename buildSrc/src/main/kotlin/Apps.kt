import org.gradle.api.JavaVersion

object Apps {
    const val minSdk = 26
    const val targetSdk = 34
    const val compileSdk = 34
    const val jvmTarget = "17"
    const val versionCode = 1
    const val versionName = "1.0.0"
    val targetCompat = JavaVersion.VERSION_17
    val sourceCompat = JavaVersion.VERSION_17
}
