package com.example.keepingtrack.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.keepingtrack.ui.uiStates.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * A little box that keeps track of things for the login screen.
 */
class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())

    val uiState : StateFlow<LoginUiState> = _uiState.asStateFlow()

    var username by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    init {
        resetLoginScreen()
    }

    fun resetLoginScreen() {
        _uiState.value = LoginUiState()
    }

    fun updateUsername(newUsername: String) {
        username = newUsername
    }

    fun updatePassword(newPassword: String) {
        password = newPassword
    }
}