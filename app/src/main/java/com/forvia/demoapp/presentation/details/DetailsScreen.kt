package com.forvia.demoapp.presentation.details

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object DetailsScreen

fun NavGraphBuilder.detailsScreenRoute(navController: NavController) {
    composable<DetailsScreen> {
        DetailsScreenRoute(navController = navController)
    }
}

@Composable
fun DetailsScreenRoute(
    navController: NavController,
    detailsScreenViewModel: DetailsViewModel = hiltViewModel()
) {
    val args = detailsScreenViewModel.args
}