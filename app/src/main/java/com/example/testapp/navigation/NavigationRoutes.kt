package com.example.testapp.navigation

sealed class NavigationRoutes(val route: String){
    object Login: NavigationRoutes("login")
    object Dashboard: NavigationRoutes("dashboard/{username}") {
        fun createRoute(username: String) = "dashboard/$username"
    }
}