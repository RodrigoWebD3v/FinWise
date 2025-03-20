package com.example.finwise.navigation.routes

sealed class LaunchRoutes(val route: String) {
    data object LaunchRoute : LaunchRoutes("launch")
}