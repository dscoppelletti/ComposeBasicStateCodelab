package com.codelabs.state

/* ADD-3 - State in Compose */
/* RESTORE-6 - After step 7, restore to step 6 */

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/* BEGIN-9 - State hoisting */
///**
// * Contains a Text composable that displays the number of glasses. The number of
// * glasses should be stored in a value called count.
// */
//@Composable
//fun WaterCounter(modifier: Modifier = Modifier) {
//    Column(modifier = modifier.padding(16.dp)) {
//        /* BEGIN-8 - Restore state in Compose */
//        // While remember helps you retain state across recompositions, it's not
//        // retained across configuration changes. For this, you must use
//        // rememberSaveable instead of remember.
//        // rememberSaveable automatically saves any value that can be saved in a
//        // Bundle.
////        var count by remember { mutableStateOf(0) }
//        var count by rememberSaveable { mutableStateOf(0) }
//        /* END- 8 */
//
//        if (count > 0) {
//            Text("You've had $count glasses.")
//        }
//        Button(onClick = { count++ }, Modifier.padding(top = 8.dp), enabled = count < 10) {
//            Text("Add one")
//        }
//    }
//}

/**
 * Displays the count and call a function when you increment the count.
 */
@Composable
fun StatelessCounter(
    count: Int, onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp),
            enabled = count < 10) {
            Text("Add one")
        }
    }
}

/**
 * Owns the state. That means that it holds the count state and modifies it when
 * calling the StatelessCounter function.
 */
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count, { count++ }, modifier)
}
/* END-9 */
