package com.example.testapp.model.userlogin

sealed class LoginUiState {
    object Idle : LoginUiState()
    object Loading : LoginUiState()
    data class Success (
        val user: UserDTO,
        val token: String
    ) : LoginUiState()
    data class Error(
        val message: String,
        val status: Int
    ) : LoginUiState()
}