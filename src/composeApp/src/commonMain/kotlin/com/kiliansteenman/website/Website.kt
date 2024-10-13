package com.kiliansteenman.website

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.profile_pic

@Composable
fun Website(title: String, subtitle: String, email: String, socials: List<Social>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.background(MaterialTheme.colors.background)
            .fillMaxSize()
    ) {
        ProfilePicture(image = Res.drawable.profile_pic)
        Text(
            text = title,
            style = MaterialTheme.typography.h1,
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.h2,
        )
        Text(
            text = email,
            style = MaterialTheme.typography.h3,
        )
        SocialBar(socials = socials)
    }
}

@Preview
@Composable
internal fun WebsitePreview() {
    MaterialTheme {
        Website(
            title = "Kilian Steenman",
            subtitle = "Software engineer - Android development",
            email = "info@kiliansteenman.com",
            socials = emptyList(),
        )
    }
}
