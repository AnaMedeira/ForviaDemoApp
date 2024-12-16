package com.forvia.demoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.forvia.demoapp.navigation.ForviaDemoNavGraph
import com.forvia.demoapp.ui.theme.ForviaDemoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
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