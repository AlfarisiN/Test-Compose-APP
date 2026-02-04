package com.example.testapp.repository

import com.example.testapp.model.userlogin.LoginUiState
import com.example.testapp.network.ApiServices
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val api: ApiServices
) {
    suspend fun login(
        username: String,
        password: String,
        app: String
    ): LoginUiState {
        return try {
            val response = api.login(username, password, app)

            if (response.status == 200 && response.data != null && response.token != null) {
                LoginUiState.Success(
                    user = response.data,
                    token = response.token
                )
            } else {
                LoginUiState.Error(
                    message = response.message ?: "Unknown error",
                    status = response.status ?: -1
                )
            }
        } catch (e: Exception) {
            LoginUiState.Error(
                message = e.localizedMessage ?: "Network error",
                status = -1
            )
        }
    }
}