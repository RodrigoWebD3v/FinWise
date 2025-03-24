package com.example.finwise.navigation.routes

sealed class HomeRoutes(val route: String) {
    data object HomeRoute : HomeRoutes("home")
}