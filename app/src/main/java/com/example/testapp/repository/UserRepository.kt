package com.example.testapp.repository

import com.example.testapp.network.ApiServices
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: ApiServices
) {
}