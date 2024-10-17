package com.kiliansteenman.website.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.RobotoSlab_Light
import website.composeapp.generated.resources.RobotoSlab_Regular
import website.composeapp.generated.resources.RobotoSlab_SemiBold

private val DarkColorScheme = darkColorScheme(
    background = Color(0xFF34353A),
    surface = Color(0xFF000222),
    onBackground = Color.White,
)

private val LightColorScheme = lightColorScheme(
    background = Color.White,
    surface = Color(0xFF000222),
)

@Composable
fun RobotoSlabFontFamily() = FontFamily(
    Font(Res.font.RobotoSlab_Light, weight = FontWeight.Light),
    Font(Res.font.RobotoSlab_Regular, weight = FontWeight.Normal),
    Font(Res.font.RobotoSlab_SemiBold, weight = FontWeight.SemiBold),
)

@Composable
fun RobotoSlabTypography() = Typography().run {
    val fontFamily = RobotoSlabFontFamily()
    copy(
        displayLarge = displayLarge.copy(
            fontFamily = fontFamily,
            fontSize = 66.sp,
        ),
        displayMedium = displayMedium.copy(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Light,
            fontSize = 24.sp,
        ),
        displaySmall = displaySmall.copy(
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp
        ),
        headlineLarge = headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = titleLarge.copy(
            fontFamily = fontFamily,
            fontSize = 42.sp,
            color = MaterialTheme.colorScheme.onBackground,
        ),
        titleMedium = titleMedium.copy(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Light,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onBackground,
        ),
        titleSmall = titleSmall.copy(
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground,
        ),
        bodyLarge = bodyLarge.copy(fontFamily = fontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = bodySmall.copy(fontFamily = fontFamily),
        labelLarge = labelLarge.copy(fontFamily = fontFamily),
        labelMedium = labelMedium.copy(fontFamily = fontFamily),
        labelSmall = labelSmall.copy(fontFamily = fontFamily)
    )
}

@Composable
fun WebTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        typography = RobotoSlabTypography(),
        colorScheme = colorScheme,
        content = content
    )
}
