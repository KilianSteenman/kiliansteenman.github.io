@file:OptIn(ExperimentalComposeUiApi::class)

package com.kiliansteenman.website

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
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
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.profile_pic

@Composable
fun Website(
    title: String,
    subtitle: String,
    email: String,
    socials: List<Social>,
    isDark: Boolean,
    onDarkThemeToggled: (Boolean) -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                space = 24.dp,
                alignment = Alignment.CenterVertically
            ),
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
                .fillMaxWidth()
                .weight(1f)
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
        Footer(
            modifier = Modifier.padding(16.dp),
            isDark = isDark,
            onDarkThemeToggled = onDarkThemeToggled
        )
    }
}

@Composable
internal fun Email(email: String) {
    var emailHover by remember { mutableStateOf(false) }
    val uriHandler = LocalUriHandler.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = email,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.clickable { uriHandler.openUri("mailto:$email") }
                .onPointerEvent(eventType = PointerEventType.Enter, onEvent = { emailHover = true })
                .onPointerEvent(eventType = PointerEventType.Exit, onEvent = { emailHover = false })
        )
        AnimatedVisibility(
            visible = emailHover,
            enter = fadeIn(),
            exit = fadeOut(),
        ) {
            HorizontalDivider(
                modifier = Modifier.width(100.dp),
                thickness = 2.dp,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Composable
internal fun Footer(
    modifier: Modifier = Modifier,
    isDark: Boolean,
    onDarkThemeToggled: (Boolean) -> Unit,
) {
    Text(
        text = "Powered by Compose Multiplatform",
        modifier = modifier
    )
    Switch(
        checked = isDark,
        onCheckedChange = { checked -> onDarkThemeToggled(checked) }
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
            isDark = true,
            onDarkThemeToggled = {},
        )
    }
}
