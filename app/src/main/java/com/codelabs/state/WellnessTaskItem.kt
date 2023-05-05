package com.codelabs.state

/* ADD-7 - Remember in Composition */

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text

/* BEGIN-10.1 - Setup */
///**
// * Displays the wellness task based on a string received as a parameter, along
// * with a Close icon button.
// */
//@Composable
//fun WellnessTaskItem(
//    taskName: String,
//    onClose: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    Row(
//        modifier = modifier, verticalAlignment = Alignment.CenterVertically
//    ) {
//        Text(
//            modifier = Modifier.weight(1f).padding(start = 16.dp),
//            text = taskName
//        )
//        IconButton(onClick = onClose) {
//            Icon(Icons.Filled.Close, contentDescription = "Close")
//        }
//    }
//}
@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = taskName
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

/* BEGIN-11 - Observable MutableList */
//@Composable
//fun WellnessTaskItem(taskName: String, modifier: Modifier = Modifier) {
//    /* BEGIN-10.2 - Restore item state in LazyList */
//    // When an item leaves the Composition, state that was remembered is
//    // forgotten. For items on a LazyColumn, items leave the Composition
//    // entirely when you scroll past them and they're no longer visible.
////    var checkedState by remember { mutableStateOf(false) }
//    // Thanks to how rememberSaveable works together with the LazyList, your
//    // items are able to also survive leaving the Composition.
//    var checkedState by rememberSaveable { mutableStateOf(false) }
//    /* END-10.2 */
//
//    WellnessTaskItem(
//        taskName = taskName,
//        checked = checkedState,
//        onCheckedChange = { newValue -> checkedState = newValue },
//        onClose = {}, // we will implement this later!
//        modifier = modifier
//    )
//}
/* END-10.1 */

/* BEGIN-12.2 - Migrate the checked state */
// We no longer need a stateful method, as the CheckBox state will be hoisted to
// the List level.
//@Composable
//fun WellnessTaskItem(
//    taskName: String, onClose: () -> Unit, modifier: Modifier = Modifier
//) {
//    var checkedState by rememberSaveable { mutableStateOf(false) }
//
//    WellnessTaskItem(
//        taskName = taskName,
//        checked = checkedState,
//        onCheckedChange = { newValue -> checkedState = newValue },
//        onClose = onClose,
//        modifier = modifier,
//    )
//}
///* END-11 */
/* END-12.2 */
