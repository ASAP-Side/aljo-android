package team.asap.aljo.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import team.asap.aljo.presentation.R


val Pretendards = FontFamily(
    Font(R.font.pretendard_bold, FontWeight.Bold),
    Font(R.font.pretendard_semi_bold, FontWeight.SemiBold),
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_regular, FontWeight.Regular)
)

val FontWeight.Companion.Regular get() = Normal

@Immutable
class AsapTypography {
    fun headLine1(
        size: Int,
        isBold: Boolean = true,
    ) = TextStyle(
        fontFamily = Pretendards,
        fontWeight = if(isBold){
            FontWeight.Bold
        }else{
             FontWeight.SemiBold
        },
        fontSize = size.sp,
        lineHeight = 30.sp,
        letterSpacing = (-2).sp,
    )

    fun body(
        size: Int,
        isMedium: Boolean = true,
    ) = TextStyle(
        fontFamily = Pretendards,
        fontWeight = if(isMedium){
            FontWeight.Medium
        }else{
            FontWeight.Regular
        },
        fontSize = size.sp,
    )
}

internal val LocalAsapTypography = staticCompositionLocalOf { AsapTypography() }