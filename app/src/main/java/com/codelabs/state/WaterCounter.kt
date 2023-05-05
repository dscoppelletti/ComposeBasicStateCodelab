package com.codelabs.state

/* ADD-3 - State in Compose */

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
        /* BEGIN-5.1 - Memory in a composable function */
//        var count = 0
//
//        Text("You've had $count glasses.")
//        Button(onClick = { count++ }, Modifier.padding(top = 8.dp)) {
//            Text("Add one")
//        }
        // Compose has a special state tracking system in place that schedules
        // recompositions for any composables that read a particular state. This
        // lets Compose be granular and just recompose those composable
        // functions that need to change, not the whole UI. This is done by
        // tracking not only "writes" (that is, state changes), but also "reads"
        // to the state.

        // Changes to count are now tracked by Compose.
        // Anyway, if you run the app now, you'll notice again that nothing
        // happens yet!
        // Scheduling recompositions is working fine. However, when a
        // recomposition happens, the variable count is re-initialized back to
        // 0, so we need a way to preserve this value across recompositions.
        /* BEGIN-5.2 - Memory in a composable function */
//        val count: MutableState<Int> = mutableStateOf(0)
        // A value calculated by remember is stored in the Composition during
        // the initial composition, and the stored value is kept across
        // recompositions.
        /* BEGIN-5.3 - Memory in a composable function */
//        val count: MutableState<Int> = remember { mutableStateOf(0) }
//        /* END-5.2 */
//
//        Text("You've had ${count.value} glasses.")
//        Button(onClick = { count.value++ }, Modifier.padding(top = 8.dp)) {
//            Text("Add one")
//        }
//        /* END-5-1. */
        // You can use the by keyword to define count as a var. Adding the
        // delegate's getter and setter imports lets us read and mutate count
        // indirectly without explicitly referring to the MutableState's value
        // property every time.
        var count by remember { mutableStateOf(0) }

        Text("You've had $count glasses.")
        Button(onClick = { count++ }, Modifier.padding(top = 8.dp)) {
            Text("Add one")
        }
        /* END-5.3 */
    }
    /* END-4 */
}


