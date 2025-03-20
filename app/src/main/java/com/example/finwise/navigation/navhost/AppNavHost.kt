package com.example.finwise.navigation.navhost


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.finwise.navigation.routes.LaunchRoutes
import com.example.finwise.navigation.routes.LoginRoutes
import com.example.finwise.views.launch.Launch
import com.example.finwise.views.login.Login

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = LaunchRoutes.LaunchRoute.route) {
        composable(route = LoginRoutes.LoginRoute.route) { Login() }
        composable(route = LaunchRoutes.LaunchRoute.route) { Launch(
            onLoginClick = { navController.navigate(LoginRoutes.LoginRoute.route) },
            onSignupClick = { navController.navigate(LoginRoutes.LoginRoute.route) }
        ) }
    }
}