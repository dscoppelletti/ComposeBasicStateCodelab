package com.codelabs.state

/* ADD-3 - State in Compose */

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Contains a Text composable that displays the number of glasses. The number of
 * glasses should be stored in a value called count.
 */
@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    val count = 0
    Text(
        text = "You've had $count glasses.",
        modifier = modifier.padding(16.dp)
    )
}


