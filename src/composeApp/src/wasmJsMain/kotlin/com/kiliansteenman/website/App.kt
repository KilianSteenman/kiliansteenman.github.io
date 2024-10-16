package com.kiliansteenman.website

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.kiliansteenman.website.theme.WebTheme
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.social_github
import website.composeapp.generated.resources.social_linkedin
import website.composeapp.generated.resources.social_x

@Composable
fun App() {
    val isSystemDark = isSystemInDarkTheme()
    var isDark by remember { mutableStateOf(isSystemDark) }

    WebTheme(darkTheme = isDark) {
        Website(
            title = "Kilian Steenman",
            subtitle = "Software Engineer - Android Development",
            email = "info@kiliansteenman.com",
            socials = listOf(
                Social(
                    title = "Github",
                    url = "https://github.com/kiliansteenman",
                    icon = Res.drawable.social_github,
                ),
                Social(
                    title = "LinkedIn",
                    url = "https://www.linkedin.com/in/kilian-steenman",
                    icon = Res.drawable.social_linkedin,
                ),
                Social(
                    title = "X",
                    url = "https://x.com/Shad0w_Link",
                    icon = Res.drawable.social_x,
                ),
            ),
            isDark = isDark,
            onDarkThemeToggled = { checked -> isDark = checked }
        )
    }
}