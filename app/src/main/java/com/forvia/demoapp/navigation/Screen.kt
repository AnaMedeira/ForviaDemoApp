package com.forvia.demoapp.navigation

import com.forvia.demoapp.util.Constants.APP_DETAILS_ID

sealed class Screen(val route: String) {

    data object HomeScreen : Screen("HomeScreen")

    //Pass the ID of the app to display the App information on the screen
    data object DetailsScreen : Screen("DetailsScreen/{$APP_DETAILS_ID}") {
        fun sendAppId(id: String): String {
            return this.route.replace(oldValue = "{$APP_DETAILS_ID}", newValue = id)
        }
    }
}