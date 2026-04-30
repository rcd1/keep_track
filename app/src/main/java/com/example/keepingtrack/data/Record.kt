package com.example.keepingtrack.data

/**
 * When users record something for the day, it will be stored right here :)
 */
data class Record(
    val counterId: Int,
    val amount: Int,
    val timestamp: Long
)
