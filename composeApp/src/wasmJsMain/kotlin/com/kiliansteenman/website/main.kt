package com.kiliansteenman.website

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlinx.browser.localStorage
import org.w3c.dom.get

private const val SETTING_DARK_THEME = "SETTING_DARK_THEME"

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val isDarkModeEnabled = localStorage[SETTING_DARK_THEME]?.equals("true")
    ComposeViewport(requireNotNull(document.body)) {
        App(isDarkModeEnabled) { isDarkModeEnabled ->
            localStorage.setItem(SETTING_DARK_THEME, isDarkModeEnabled.toString())
        }
    }
}