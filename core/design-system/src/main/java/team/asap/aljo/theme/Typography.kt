package team.asap.aljo.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import team.asap.aljo.designsystem.R

val Pretendards = FontFamily(
    Font(R.font.pretendard_bold, FontWeight.Bold),
    Font(R.font.pretendard_semi_bold, FontWeight.SemiBold),
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_regular, FontWeight.Regular)
)

val FontWeight.Companion.Regular get() = Normal

@Immutable
class AsapTypography {
    fun pretendard(
        size: Int,
        fontWeight: FontWeight = FontWeight.Bold
    ) = TextStyle(
        fontFamily = Pretendards,
        fontWeight = fontWeight,
        fontSize = size.sp,
        lineHeight = size.getLineHeightBySize(),
        letterSpacing = (-2).sp,
    )
}

private fun Int.getLineHeightBySize() = when (this) {
    11 -> (this + 6).sp
    12 -> (this + 6).sp
    15 -> (this + 9).sp
    else -> {
        (this + 8).sp
    }
}

internal val LocalAsapTypography = staticCompositionLocalOf { AsapTypography() }
