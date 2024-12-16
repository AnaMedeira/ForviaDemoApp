package com.forvia.demoapp.presentation.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.forvia.demoapp.navigation.Screen


fun NavGraphBuilder.homeScreenRoute(navController: NavController) {
    composable(Screen.HomeScreen.route) {
        HomeScreen(navController = navController)
    }
}

@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel = hiltViewModel()) {
}