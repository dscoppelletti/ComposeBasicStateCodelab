package com.codelabs.state

/* ADD-3 - State in Compose */

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * The whole screen.
 */
/* BEGIN-12.1 - Migrate the list and remove method */
//@Composable
//fun WellnessScreen(modifier: Modifier = Modifier) {
//    /* BEGIN-9 - State hoisting */
////    WaterCounter(modifier)
//    /* BEGIN-10.1 - Setup */
////    StatefulCounter(modifier)
//    /* END-9 */
//    Column(modifier = modifier) {
//        StatefulCounter()
//        /* BEGIN-11 - Observable MutableList */
////        WellnessTasksList()
//
//        // ArrayList<T> or mutableListOf don't notify Compose that the items in
//        // the list have changed and schedule a recomposition of the UI.
//        // You need to create an instance of MutableList that is observable by
//        // Compose. This structure lets Compose track changes to recompose the
//        // UI when items are added or removed from the list.
//        // The extension function toMutableStateList() is the way to create an
//        // observable MutableList from an initial mutable or immutable
//        // Collection, such as List.
//        // Alternatively, you could also use the factory method
//        // mutableStateListOf to create the observable MutableList and then add
//        // the elements for your initial state.
//        //
//        // If you just define the list and then add the tasks in a different
//        // operation it would result in duplicated items being added for every
//        // recomposition.
//        // ---
//        // val list = remember { mutableStateListOf<WellnessTask>() }
//        // list.addAll(getWellnessTasks())
//        // ---
//        // Instead, create the list with its initial value in a single
//        // operation and then pass it to the remember function, like this:
//        // ---
//        // val list = remember {
//        // mutableStateListOf<WellnessTask>().apply {
//        //     addAll(getWellnessTasks())
//        // }
//        // ---
//        //
//        // If you try to use rememberSaveable() to store the list, you'll get a
//        // runtime exception:
//        // ---
//        // cannot be saved using the current SaveableStateRegistry. The default
//        // implementation only supports types which can be stored inside the
//        // Bundle. Please consider implementing a custom Saver for this class
//        // and pass it to rememberSaveable().
//        // ---
//        // This error tells you that you need to provide a custom saver.
//        // However, you shouldn't be using rememberSaveable to store large
//        // amounts of data or complex data structures that require lengthy
//        // serialization or deserialization.
//        // ndr - However, now, if run the App, delete some tasks and then
//        // change configuration (ex. rotate the device), the removed tasks
//        // reappear since the list is recreated.
//        val list = remember { getWellnessTasks().toMutableStateList() }
//        WellnessTasksList(
//            list = list,
//            onCloseTask = { task -> list.remove(task) }
//        )
//        /* END-11 */
//    }
//    /* END-10.1 */
//}
//
///* BEGIN-11 - Observable Mutablist */
//private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }
///* END-11 */

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    // viewModel() returns an existing ViewModel or creates a new one in the
    // given scope.
    // Instantiate the wellnessViewModel ViewModel by calling viewModel(), as
    // parameter of the Screen composable, so it can be replaced when testing
    // this composable, and hoisted if required.
    // ViewModel won't automatically persist the state of the app in any
    // scenario (for example, for system-initiated process death).
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter()

        // ViewModels are recommended to be used at screen-level composables,
        // that is, close to a root composable called from an activity,
        // fragment, or destination of a Navigation graph. ViewModels should
        // never be passed down to other composables, instead you should pass
        // only the data they need and functions that perform the required logic
        // as parameters.
        WellnessTasksList(
            list = wellnessViewModel.tasks,
            /* BEGIN-12.2 - Migrate the checked state */
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
            /* END-12.2 */
            onCloseTask = { task -> wellnessViewModel.remove(task) })
    }
}
/* END-12.1 */
