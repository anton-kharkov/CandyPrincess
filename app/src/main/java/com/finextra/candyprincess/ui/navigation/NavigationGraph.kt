package com.finextra.candyprincess.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.finextra.candyprincess.ui.screen.GameScreen
import com.finextra.candyprincess.ui.screen.HomeScreen
import com.finextra.candyprincess.ui.screen.PrivatePolicyScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home") {
            HomeScreen(navController)
        }
        composable(route = "private_policy") {
            PrivatePolicyScreen()
        }
        composable(route = "game") {
            GameScreen()
        }
    }
}