package team.asap.aljo.theme

import androidx.compose.material.lightColors
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Red01 = Color(0xFFFD2F7A)

val Title = Color(0xFF222222)

val Error = Color(0xFFDE0000)

@Stable
data class AsapPrimary(
    val red01: Color,
)

internal val LocalPrimary = staticCompositionLocalOf {
    AsapPrimary(Red01)
}

