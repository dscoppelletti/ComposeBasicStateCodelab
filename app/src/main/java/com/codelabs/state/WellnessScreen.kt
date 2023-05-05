package com.codelabs.state

/* ADD-3 - State in Compose */

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * The whole screen.
 */
@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    /* BEGIN-9 - State hoisting */
//    WaterCounter(modifier)
    /* BEGIN-10.1 - Setup */
//    StatefulCounter(modifier)
    /* END-9 */
    Column(modifier = modifier) {
        StatefulCounter()
        WellnessTasksList()
    }
    /* END-10.1 */
}

