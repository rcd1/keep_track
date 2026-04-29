package com.example.keepingtrack.data

/**
 * First iteration will be stupid, only stupid people implement the first time.
 * you are stupid.
 */
data class Counter(
    val id: Int,
    var name: String,
    var count: Int = 0,
    var isDone: Boolean = false,
    var type: CounterType = CounterType.COUNT
)

enum class CounterType {
    COUNT,
    BOOLEAN
}
