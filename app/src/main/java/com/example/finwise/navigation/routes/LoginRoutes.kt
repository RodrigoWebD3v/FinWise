package com.example.finwise.navigation.routes

sealed class LoginRoutes(val route: String) {
    data object LoginRoute : LoginRoutes("login")
}