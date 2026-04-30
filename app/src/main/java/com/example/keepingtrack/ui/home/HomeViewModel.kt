package com.example.keepingtrack.ui.home

import androidx.lifecycle.ViewModel
import com.example.keepingtrack.data.Counter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HomeViewModel : ViewModel() {
    // Once the add counter button's in here, you'll be done for~
    private val _uiState = MutableStateFlow(
        HomeUiState(
            counters = listOf(
                Counter(1, "Birds Seen", 0),
                Counter(2, "Red Lights on the Way to School", 0)
            )
        )
    )
    val uiState: StateFlow<HomeUiState> = _uiState

    /**
     *  Some counter go up
     */

    fun increment(counter: Counter) {
        _uiState.value = _uiState.value.copy(
            counters = _uiState.value.counters.map {
                if (it.id == counter.id) it.copy(count = it.count + 1)
                else it
            }
        )
    }

    /**
     * Some counter go down
     */
    fun decrement(counter: Counter) {
        if (counter.count < 1) return
        _uiState.value = _uiState.value.copy(
            counters = _uiState.value.counters.map {
                if (it.id == counter.id) it.copy(count = it.count - 1)
                else it
            }
        )
    }

    /**
     * Some counter get a write in the text field
     */
    fun updateCount(counter: Counter, newCount: Int) {
        _uiState.value = _uiState.value.copy(
            counters = _uiState.value.counters.map {
                if (it.id == counter.id) it.copy(count = newCount)
                else it
            }
        )
    }

    /**
     * To update the day displayed on the home screen
     * & eventually to be used as the key for record values?
     * idea may need to marinate.
     */
    fun getCurrentDate(): String {
        val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
        return sdf.format(Date())
    }

}