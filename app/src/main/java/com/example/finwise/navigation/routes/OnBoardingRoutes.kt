package com.example.finwise.navigation.routes

sealed class OnBoardingRoutes(val route: String) {
    data object OnBoardingRoute : OnBoardingRoutes("onBoarding")
}