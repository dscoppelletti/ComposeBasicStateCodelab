package com.codelabs.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/* ADD-10.1 - Setup */

/* BEGIN-12.2 - Migrate the checked state */
// Migrate the checked state and logic to the ViewModel. This way the
// code is simpler and more testable, with all state managed by the
// ViewModel.
//data class WellnessTask(val id: Int, val label: String)

class WellnessTask(
    val id: Int,
    val label: String,
    initialChecked: Boolean = false
) {
    // Make checked state observable, because compose is tracking for the
    // MutableList are changes related to adding and removing elements, but it's
    // unaware of changes in the row item values (checked state in our case),
    // unless you tell it to track them too.
    var checked by mutableStateOf(initialChecked)
}
/* END-12.2 */
