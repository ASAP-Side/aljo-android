@file:OptIn(ExperimentalFoundationApi::class)

package team.asap.aljo.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object AsapTheme {
    val primary: AsapPrimary
        @Composable
        @ReadOnlyComposable
        get() = LocalPrimary.current

    val basic: AsapBasic
        @Composable
        @ReadOnlyComposable
        get() = LocalBasic.current

    val greyscale: AsapGreyscale
        @Composable
        @ReadOnlyComposable
        get() = LocalGreyScale.current

    val additional: AsapAdditional
        @Composable
        @ReadOnlyComposable
        get() = LocalAdditional.current

    val icon: AsapIcon
        @Composable
        @ReadOnlyComposable
        get() = LocalIcon.current


    val typography: AsapTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalAsapTypography.current

}

@Composable
fun AsapTheme(
    primary: AsapPrimary = AsapTheme.primary,
    basic: AsapBasic = AsapTheme.basic,
    greyscale: AsapGreyscale = AsapTheme.greyscale,
    additional: AsapAdditional = AsapTheme.additional,
    icon: AsapIcon = AsapTheme.icon,
    typography: AsapTypography = AsapTheme.typography,
    content: @Composable () -> Unit,
) {
    val rippleIndication = rememberRipple()
    CompositionLocalProvider(
        LocalPrimary provides primary,
        LocalBasic provides basic,
        LocalGreyScale provides greyscale,
        LocalAdditional provides additional,
        LocalIcon provides icon,
        LocalIndication provides rippleIndication,
        LocalAsapTypography provides typography,
        LocalOverscrollConfiguration provides null,
        content = content,
    )
}
