package com.example.keepingtrack.ui.home

import androidx.lifecycle.ViewModel
import com.example.keepingtrack.data.Counter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        HomeUiState(
            counters = listOf(
                Counter(1, "Water", 0),
                Counter(2, "Steps", 0, true)
            )
        )
    )
    val uiState: StateFlow<HomeUiState> = _uiState

    fun increment(counter: Counter) {
        _uiState.value = _uiState.value.copy(
            counters = _uiState.value.counters.map {
                if (it.id == counter.id) it.copy(count = it.count + 1)
                else it
            }
        )
    }

    fun addCounter(name: String) {
        val new = Counter(
            id = _uiState.value.counters.size + 1,
            name = name
        )
        _uiState.value = _uiState.value.copy(
            counters = _uiState.value.counters + new
        )
    }
}