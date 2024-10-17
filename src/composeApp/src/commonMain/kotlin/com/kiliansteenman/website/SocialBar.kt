package com.kiliansteenman.website

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

data class Social(
    val title: String,
    val icon: DrawableResource,
    val url: String,
)

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun SocialBar(socials: List<Social>) {
    FlowRow(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(percent = 100),
            )
            .shadow(elevation = 10.dp, shape = RoundedCornerShape(percent = 100))
            .padding(8.dp),
    ) {
        socials.forEach { social ->
            SocialItem(social)
        }
    }
}

@Composable
internal fun SocialItem(social: Social) {
    val uriHandler = LocalUriHandler.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { uriHandler.openUri(social.url) }
    ) {
        Image(
            painter = painterResource(resource = social.icon),
            contentDescription = social.title,
            modifier = Modifier
                .background(color = Color.White, shape = CircleShape)
                .padding(8.dp)
                .size(24.dp),
        )
    }
}
