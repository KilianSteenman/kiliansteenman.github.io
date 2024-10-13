@file:OptIn(ExperimentalComposeUiApi::class)

package com.kiliansteenman.website

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.profile_pic

@Composable
fun Website(title: String, subtitle: String, email: String, socials: List<Social>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 24.dp,
            alignment = Alignment.CenterVertically
        ),
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ) {
        ProfilePicture(image = Res.drawable.profile_pic)
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.titleMedium,
        )
        Email(email = email)
        SocialBar(socials = socials)
    }
}

@Composable
internal fun Email(email: String) {
    var emailHover by remember { mutableStateOf(false) }
    val uriHandler = LocalUriHandler.current

    Text(
        text = email,
        style = MaterialTheme.typography.titleSmall.copy(
            textDecoration = if (emailHover) TextDecoration.Underline else TextDecoration.None,
        ),
        modifier = Modifier.clickable { uriHandler.openUri("mailto:$email") }
            .onPointerEvent(eventType = PointerEventType.Enter, onEvent = { emailHover = true })
            .onPointerEvent(eventType = PointerEventType.Exit, onEvent = { emailHover = false })
    )
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
