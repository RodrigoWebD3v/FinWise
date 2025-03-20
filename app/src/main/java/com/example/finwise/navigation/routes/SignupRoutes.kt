package com.example.finwise.navigation.routes

sealed class SignupRoutes(val route: String) {
    data object SignupRoute : SignupRoutes("signup")
}