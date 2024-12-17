package com.forvia.demoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.forvia.demoapp.presentation.details.detailsScreenRoute
import com.forvia.demoapp.presentation.home.HomeScreen
import com.forvia.demoapp.presentation.home.homeScreen

@Composable
fun ForviaDemoNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = HomeScreen) {

        //Home screen
        homeScreen(navController = navController)

        //Details Screen
        detailsScreenRoute(navController = navController)

    }
}