plugins {
    `java-library`
    id("kotlin")
}

java {
    sourceCompatibility = Apps.sourceCompat
    targetCompatibility = Apps.targetCompat
}

dependencies {
    implementation(Dependencies.Kotlin.Coroutine)
    implementation(Dependencies.Javax.Inject)
}