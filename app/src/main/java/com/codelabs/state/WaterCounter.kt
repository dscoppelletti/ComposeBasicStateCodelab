package com.codelabs.state

/* ADD-3 - State in Compose */

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
    /* BEGIN-4 - Events in Compose */
    // When you run the app and click the button, notice that nothing happens.
    // Setting a different value for the count variable won't make Compose
    // detect it as a state change so nothing happens. This is because you
    // haven't told Compose that it should redraw the screen (that is,
    // "recompose" the composable function), when the state changes.
//    val count = 0
//    Text(
//        text = "You've had $count glasses.",
//        modifier = modifier.padding(16.dp)
//    )
    Column(modifier = modifier.padding(16.dp)) {
        var count = 0
        Text("You've had $count glasses.")
        Button(onClick = { count++ }, Modifier.padding(top = 8.dp)) {
            Text("Add one")
        }
    }
    /* END-4 */
}


