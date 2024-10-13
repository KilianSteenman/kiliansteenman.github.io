package com.kiliansteenman.website

import androidx.compose.runtime.Composable
import com.kiliansteenman.website.theme.WebTheme
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.social_github
import website.composeapp.generated.resources.social_linkedin
import website.composeapp.generated.resources.social_x

@Composable
fun App() {
    WebTheme {
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
                    url = "X",
                    icon = Res.drawable.social_x,
                ),
            ),
        )
    }
}