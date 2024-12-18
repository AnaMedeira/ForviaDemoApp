package com.forvia.demoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.forvia.demoapp.navigation.ForviaDemoNavGraph
import com.forvia.demoapp.ui.theme.ForviaDemoAppTheme
import com.forvia.domain.useCase.GetLocalAppsUseCase
import com.forvia.domain.useCase.SaveLocalAppsUseCase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @Inject
    lateinit var getLocalAppsUseCase: GetLocalAppsUseCase

    @Inject
    lateinit var saveLocalAppsUseCase: SaveLocalAppsUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ForviaDemoAppTheme {
                val navController = rememberNavController()
                ForviaDemoNavGraph(navController)
            }
        }
    }
}