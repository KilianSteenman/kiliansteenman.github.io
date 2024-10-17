@file:OptIn(ExperimentalComposeUiApi::class)

package com.kiliansteenman.website

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.profile_pic

@Composable
fun Website(
    title: String,
    subtitle: String,
    socials: List<Social>,
    isDark: Boolean,
    onDarkThemeToggled: (Boolean) -> Unit,
) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {
        Body(
            title = title,
            subtitle = subtitle,
            socials = socials,
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
                .verticalScroll(scrollState)
                .padding(16.dp)
                .fillMaxWidth()
                .weight(1f)
        )
        Footer(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            isDark = isDark,
            onDarkThemeToggled = onDarkThemeToggled
        )
    }
}

@Composable
internal fun Body(
    title: String,
    subtitle: String,
    socials: List<Social>,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 24.dp,
            alignment = Alignment.CenterVertically
        ),
        modifier = modifier,
    ) {
        ProfilePicture(image = Res.drawable.profile_pic)
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center,
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center,
        )
        SocialBar(socials = socials)
    }
}

@Composable
internal fun Footer(
    isDark: Boolean,
    onDarkThemeToggled: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            text = "Powered by Compose Multiplatform",
            modifier = Modifier.weight(1f)
                .padding(end = 8.dp)
        )
        Switch(
            checked = isDark,
            onCheckedChange = { checked -> onDarkThemeToggled(checked) }
        )
    }
}

@Preview
@Composable
internal fun WebsitePreview() {
    MaterialTheme {
        Website(
            title = "Kilian Steenman",
            subtitle = "Software engineer - Android development",
            socials = emptyList(),
            isDark = true,
            onDarkThemeToggled = {},
        )
    }
}
