package com.kiliansteenman.website

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProfilePicture(modifier: Modifier = Modifier, image: DrawableResource) {
    Image(
        painter = painterResource(image),
        contentDescription = null,
        modifier = modifier.size(200.dp)
            .border(
                shape = CircleShape,
                border = BorderStroke(width = 8.dp, color = Color.White),
            )
            .shadow(elevation = 8.dp, shape = CircleShape)
            .background(color = Color.White)
            .clip(CircleShape),
    )
}
