package com.example.keepingtrack.ui.home

import com.example.keepingtrack.data.Counter

data class HomeUiState(
    val counters: List<Counter> = emptyList()
)
