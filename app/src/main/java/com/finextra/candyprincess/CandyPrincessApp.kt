package com.finextra.candyprincess

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.finextra.candyprincess.ui.navigation.NavigationGraph
import com.finextra.candyprincess.ui.theme.CandyPrincessTheme

@Composable
fun CandyPrincessApp() {
    CandyPrincessTheme {
        val navController = rememberNavController()
        NavigationGraph(navController = navController)
    }
}