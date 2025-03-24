package com.example.finwise.navigation.navhost


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.finwise.navigation.routes.HomeRoutes
import com.example.finwise.navigation.routes.LaunchRoutes
import com.example.finwise.navigation.routes.LoginRoutes
import com.example.finwise.navigation.routes.OnBoardingRoutes
import com.example.finwise.navigation.routes.SignupRoutes
import com.example.finwise.views.home.Home
import com.example.finwise.views.launch.Launch
import com.example.finwise.views.login.Login
import com.example.finwise.views.onboarding.OnBoarding
import com.example.finwise.views.signup.Signup

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = LaunchRoutes.LaunchRoute.route) {
        composable(route = LoginRoutes.LoginRoute.route) { Login(
            onSignupClick = { navController.navigate(SignupRoutes.SignupRoute.route) },
            onHomeClick = { navController.navigate(HomeRoutes.HomeRoute.route) }
        ) }
        composable(route = SignupRoutes.SignupRoute.route) { Signup(
            onSigninClick = { navController.navigate(LoginRoutes.LoginRoute.route) },
            onSignupClick = {
                navController.navigate(OnBoardingRoutes.OnBoardingRoute.route) {
                    popUpTo(SignupRoutes.SignupRoute.route) { inclusive = true }
                    launchSingleTop = true
                }
            },
        ) }
        composable(route = LaunchRoutes.LaunchRoute.route) { Launch(
            onSigninClick = { navController.navigate(LoginRoutes.LoginRoute.route) },
            onSignupClick = { navController.navigate(SignupRoutes.SignupRoute.route) },
        )
        }
        composable(route = OnBoardingRoutes.OnBoardingRoute.route) {
            OnBoarding(
                onConfirmClick = { navController.navigate(HomeRoutes.HomeRoute.route) }
        ) }

        composable(route = HomeRoutes.HomeRoute.route) {
            Home(

            )
        }
    }
}