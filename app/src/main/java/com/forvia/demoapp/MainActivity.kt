package com.forvia.demoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkManager.*
import com.forvia.demoapp.navigation.ForviaDemoNavGraph
import com.forvia.demoapp.presentation.notification.NotificationHelper
import com.forvia.demoapp.presentation.notification.NotificationWorker
import com.forvia.demoapp.ui.theme.ForviaDemoAppTheme
import com.forvia.demoapp.util.Constants
import com.forvia.domain.useCase.GetLocalAppsUseCase
import com.forvia.domain.useCase.SaveLocalAppsUseCase
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @Inject
    lateinit var getLocalAppsUseCase: GetLocalAppsUseCase

    @Inject
    lateinit var saveLocalAppsUseCase: SaveLocalAppsUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create notification channel
        NotificationHelper.createNotificationChannel(this)

        // Schedule periodic work
        setupPeriodicWork()

        enableEdgeToEdge()
        setContent {
            ForviaDemoAppTheme {
                val navController = rememberNavController()
                ForviaDemoNavGraph(navController)
            }
        }
    }

    private fun setupPeriodicWork() {

        val data = Data.Builder()
            .putString(Constants.NOTIFICATION_TITLE, getString(R.string.notification_title))
            .putString(Constants.NOTIFICATION_MESSAGE, getString(R.string.notification_message))
            .build()


        val workRequest = PeriodicWorkRequestBuilder<NotificationWorker>(30, TimeUnit.SECONDS)
            .setConstraints(
                Constraints.Builder()
                    .build()
            )
            .setInputData(data)
            .build()

        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "NotificationWork",
            ExistingPeriodicWorkPolicy.KEEP, // Keeps existing work if already scheduled
            workRequest
        )


    }
}