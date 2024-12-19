package com.forvia.demoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.forvia.demoapp.presentation.details.detailsScreen
import com.forvia.demoapp.presentation.home.HomeScreen
import com.forvia.demoapp.presentation.home.homeScreen

@Composable
fun ForviaDemoNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = HomeScreen) {
        homeScreen(navController = navController)

        detailsScreen(navController = navController)
    }
}