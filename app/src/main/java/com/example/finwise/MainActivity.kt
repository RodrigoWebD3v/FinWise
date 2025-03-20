package com.example.finwise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finwise.navigation.navhost.AppNavHost
import com.example.finwise.navigation.routes.LoginRoutes
import com.example.finwise.ui.theme.FinWiseTheme
import com.example.finwise.views.launch.Launch
import com.example.finwise.views.login.Login

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinWiseTheme {
                val navHostController = rememberNavController()
                AppNavHost(navHostController)
            }
        }
    }
}

