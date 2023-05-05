package com.codelabs.state

/* ADD-10.1 - Setup */

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/* BEGIN-11 - Observable MutableList */
//@Composable
//fun WellnessTasksList(
//    modifier: Modifier = Modifier,
//    list: List<WellnessTask> = remember { getWellnessTasks() }
//) {
//    LazyColumn(
//        modifier = modifier
//    ) {
//        items(list) { task ->
//            WellnessTaskItem(taskName = task.label)
//        }
//    }
//}
//
//private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        // The items method receives a key parameter. By default, each item's
        // state is keyed against the position of the item in the list.
        // In a mutable list, this causes issues when the data set changes,
        // since items that change position effectively lose any remembered
        // state.
        // You can easily fix this by using the id of each WellnessTaskItem as
        // the key for each item.
        items(
            items = list,
            key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(
                taskName = task.label,
                onClose = { onCloseTask(task) }
            )
        }
    }
}
/* END-11 */
