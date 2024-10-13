package com.kiliansteenman.website

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

data class Social(
    val title: String,
    val icon: DrawableResource,
    val url: String,
)

@Composable
internal fun SocialBar(socials: List<Social>) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        modifier = Modifier
            .background(
                color = MaterialTheme.colors.secondary,
                shape = RoundedCornerShape(percent = 100),
            )
            .shadow(10.dp)
            .padding(8.dp),
    ) {
        socials.forEach { social ->
            SocialItem(social)
        }
    }
}

@Composable
internal fun SocialItem(social: Social) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(resource = social.icon),
            contentDescription = social.title,
            modifier = Modifier.size(30.dp),
        )
        Text(text = social.title)
    }
}
