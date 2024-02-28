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

    val typography: AsapTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalAsapTypography.current

}

@Composable
fun AsapTheme(
    primary: AsapPrimary = AsapTheme.primary,
    typography: AsapTypography = AsapTheme.typography,
    content: @Composable () -> Unit,
) {
    val rippleIndication = rememberRipple()
    CompositionLocalProvider(
        LocalPrimary provides primary,
        LocalIndication provides rippleIndication,
        LocalAsapTypography provides typography,
        LocalOverscrollConfiguration provides null,
        content = content,
    )
}