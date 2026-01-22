package com.example.testapp.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.model.userlogin.LoginUiState
import com.example.testapp.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
    val uiState: StateFlow<LoginUiState> = _uiState

    fun login(username: String, password: String, app: String) {
        if (username.isBlank() || password.isBlank()) {
            _uiState.value = LoginUiState.Error("Username & password required", 400)
            return
        }

        viewModelScope.launch {
            _uiState.value = LoginUiState.Loading
            try {
                val response = RetrofitClient.api.login(username, password, app)
                println(response)
                if (response.status == 200) {
                    _uiState.value = LoginUiState.Success(
                        user = response.data!!,
                        token = response.token!!,
                    )
                } else if (response.status == 401) {
                    _uiState.value = LoginUiState.Error(
                        message = response.message!!,
                        status = response.status!!
                    )
                } else {
                    println("here")
                    _uiState.value = LoginUiState.Error(
                        message = "Something went wrong!",
                        status = 98
                    )
                }
            } catch (e: Exception) {
                println("here ex")
                _uiState.value = LoginUiState.Error(
                    message = e.message!!,
                    status = 99
                )
            }
        }
    }
}