package team.asap.aljo.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Red01 = Color(0xFFFD2F7A)
val Red02 = Color(0xFFFFB4D6)

val Black01 = Color(0xFF222222)
val Black02 = Color(0xFF666666)
val Black03 = Color(0xFF888888)
val Black04 = Color(0xFFB8B8B8)

val White = Color(0xFFFFFFFF)
val Grey01 = Color(0xFFF2F2F2)
val Grey02 = Color(0xFFE3E3E3)
val Grey03 = Color(0xFFCCCCCC)
val Grey04 = Color(0xFFAAAAAA)

val Error = Color(0xFFDE0000)

val Blue = Color(0xFF0066FF)
val Green = Color(0xFF17C07E)

data class AsapPrimary(
    val red01: Color,
    val red02: Color,
)

data class AsapBasic(
    val black01: Color,
    val black02: Color,
    val black03: Color,
    val black04: Color,
)

data class AsapGreyscale(
    val white: Color,
    val grey01: Color,
    val grey02: Color,
    val grey03: Color,
    val grey04: Color,
)

data class AsapAdditional(
    val error: Color,
)

data class AsapIcon(
    val blue: Color,
    val green: Color,
)

internal val LocalPrimary = staticCompositionLocalOf {
    AsapPrimary(
        red01 = Red01,
        red02 = Red02,
    )
}

internal val LocalBasic = staticCompositionLocalOf {
    AsapBasic(
        black01 = Black01,
        black02 = Black02,
        black03 = Black03,
        black04 = Black04,
    )
}

internal val LocalGreyScale = staticCompositionLocalOf {
    AsapGreyscale(
        white = White,
        grey01 = Grey01,
        grey02 = Grey02,
        grey03 = Grey03,
        grey04 = Grey04,
    )
}

internal val LocalAdditional = staticCompositionLocalOf {
    AsapAdditional(
        error = Error
    )
}

internal val LocalIcon = staticCompositionLocalOf {
    AsapIcon(
        blue = Blue,
        green = Green,
    )
}