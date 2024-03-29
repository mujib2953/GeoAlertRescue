package com.adnacoder.geoalertrescue

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adnacoder.geoalertrescue.screens.HomeScreen
import com.adnacoder.geoalertrescue.screens.SplashScreen

@Composable
fun AppNav() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash_screen",
    ) {
        composable("splash_screen") {
            SplashScreen(
                navController = navController,
            )
        }

        composable("home_screen") {
            HomeScreen()
        }
    }
}
