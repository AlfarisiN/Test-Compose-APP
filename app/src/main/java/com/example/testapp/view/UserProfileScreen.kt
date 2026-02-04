package com.example.testapp.view

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testapp.viewmodel.LoginViewModel
import com.example.testapp.viewmodel.UserProfileVIewModel

@Composable
fun UserProfileScreen (
    viewModel: UserProfileVIewModel = viewModel(factory = daggerViewModelFactory)
) {

}