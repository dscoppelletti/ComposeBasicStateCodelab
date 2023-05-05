package com.codelabs.state

/* ADD-3 - State in Compose */

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * The whole screen.
 */
@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    WaterCounter(modifier)
}

