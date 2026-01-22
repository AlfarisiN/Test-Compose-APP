package com.example.testapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.testapp.model.userlogin.LoginUiState
import com.example.testapp.navigation.NavigationRoutes
import com.example.testapp.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = viewModel()
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val uiState by viewModel.uiState.collectAsState()

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = username,
            onValueChange = {username = it},
            label = { Text("Username") }
        )
        Spacer(Modifier.height(10.dp))
        TextField(
            value = password,
            onValueChange = {password = it},
            label = {Text("Password")}
        )
        Spacer(Modifier.height(10.dp))
        Button(
            onClick = { viewModel.login(username, password, "2")},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,      // Button background
                contentColor = Color.White        // Text color
            )

        ) {
            Text("Login")
        }
        Spacer(Modifier.height(10.dp))

        when (uiState) {
            is LoginUiState.Loading -> CircularProgressIndicator()
            is LoginUiState.Success -> {
                val user = (uiState as LoginUiState.Success).user

                LaunchedEffect(Unit) {
                    navController.navigate(
                        NavigationRoutes.Dashboard.createRoute(user.username!!)
                    ) {
                        popUpTo(NavigationRoutes.Login.route) {
                            inclusive = true
                        }
                    }
                }
            }
            is LoginUiState.Error ->
                Text(
                    (uiState as LoginUiState.Error).message,
                    color = Color.Red
                )
            else -> {}
        }
    }
}