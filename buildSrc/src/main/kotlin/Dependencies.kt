object Dependencies {

    object Kotlin {
        const val Coroutine =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.Coroutines}"
        const val ImmutableCollections =
            "org.jetbrains.kotlinx:kotlinx-collections-immutable:${Versions.Kotlin.ImmutableCollections}"
    }

    object Firebase {
        const val Bom = "com.google.firebase:firebase-bom:${Versions.Firebase.Bom}"
    }

    object Login {
        const val Kakao = "com.kakao.sdk:v2-user:${Versions.Login.Kakao}"
    }

    object Hilt {
        const val Core = "com.google.dagger:hilt-core:${Versions.Jetpack.Hilt}"
        const val Android = "com.google.dagger:hilt-android:${Versions.Jetpack.Hilt}"
        const val Kapt = "com.google.dagger:hilt-android-compiler:${Versions.Jetpack.Hilt}"
    }

    object Javax {
        const val Inject = "javax.inject:javax.inject:${Versions.Di.Inject}"
    }

    object Room {
        const val Core = "androidx.room:room-ktx:${Versions.Jetpack.Room}"
        const val Compiler = "androidx.room:room-compiler:${Versions.Jetpack.Room}"
    }

    val Network = listOf(
        "com.squareup.retrofit2:retrofit:${Versions.Network.Retrofit}",
        "com.squareup.okhttp3:logging-interceptor:${Versions.Network.OkHttp}", //http 인터셉터
        "com.squareup.okhttp3:okhttp:${Versions.Network.OkHttp}", //네트워크 통신을 위한 라이브러리,
        "com.squareup.retrofit2:converter-gson:${Versions.Network.Retrofit}", //직렬화 라이브러리
    )

    object Paging {
        const val Runtime =
            "androidx.paging:paging-runtime:${Versions.Jetpack.Paging}" //paging runtime
        const val Common =
            "androidx.paging:paging-common:${Versions.Jetpack.Paging}" //domain을 위한 안드로이드 의존성 제거
    }

    object AppCompat {
        const val Core = "androidx.appcompat:appcompat:${Versions.AppCompat.Core}"
    }

    object Compose {
        val core = listOf(
            "androidx.compose.ui:ui:${Versions.Compose.Main}", // 레이아웃, 그리기등에 필요한 상호작용 구성요소
            "androidx.compose.runtime:runtime:${Versions.Compose.Main}", //상태 관리 구성요소
            "androidx.compose.foundation:foundation:${Versions.Compose.Main}", //디자인 요소에 대한 기초 레이아웃
            "androidx.compose.material:material:${Versions.Compose.Material}", //머터리얼 컴포저블
            "androidx.paging:paging-compose:${Versions.Compose.Paging}",
        )
        val sub = listOf(
            "androidx.activity:activity-compose:${Versions.Compose.Activity}", //for componentActivity use compose
            "androidx.lifecycle:lifecycle-runtime-compose:${Versions.Compose.Lifecycle}", // lifecycle에 맞게 state 수집을 위함
            "io.coil-kt:coil-compose:${Versions.Compose.Coil}",
        )
    }

    object Logging{
        const val Timber = "com.jakewharton.timber:timber:${Versions.Timber.Core}"
        const val Stetho = "com.facebook.stetho:stetho:${Versions.Network.Stetho}"
    }

    val Test = listOf(
        "junit:junit:${Versions.Test.JUnit}",
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Test.Coroutine}",
        "io.mockk:mockk:${Versions.Test.Mockk}",
        "io.strikt:strikt-core:${Versions.Test.Strikt}"
    )
}
