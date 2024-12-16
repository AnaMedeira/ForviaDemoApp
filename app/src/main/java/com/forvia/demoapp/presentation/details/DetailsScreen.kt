package com.forvia.demoapp.presentation.details

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.forvia.demoapp.navigation.Screen


fun NavGraphBuilder.detailsScreenRoute(navController: NavController) {
    composable(Screen.DetailsScreen.route) {
        DetailsScreen(navController = navController)
    }
}

@Composable
fun DetailsScreen(
    navController: NavController,
    detailsScreenViewModel: DetailsViewModel = hiltViewModel()
) {
    val args = detailsScreenViewModel.args
}