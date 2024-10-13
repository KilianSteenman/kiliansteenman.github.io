package com.kiliansteenman.website

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.github
import website.composeapp.generated.resources.linkedin

@Composable
fun App() {
    MaterialTheme {
        Website(
            title = "Kilian Steenman",
            subtitle = "Software Engineer - Android Development",
            email = "info@kiliansteenman.com",
            socials = listOf(
                Social(
                    title = "Github",
                    url = "https://github.com/kiliansteenman",
                    icon = Res.drawable.github,
                ),
                Social(
                    title = "LinkedIn",
                    url = "https://www.linkedin.com/in/kilian-steenman",
                    icon = Res.drawable.linkedin,
                ),
                Social(
                    title = "X",
                    url = "X",
                    icon = Res.drawable.linkedin,
                ),
            ),
        )
//        var showContent by remember { mutableStateOf(false) }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click me!")
//            }
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
    }
}