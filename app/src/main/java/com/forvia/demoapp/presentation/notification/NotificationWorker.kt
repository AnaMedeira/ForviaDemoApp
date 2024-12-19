package com.forvia.demoapp.presentation.notification

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.forvia.demoapp.util.Constants
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject


@HiltWorker
class NotificationWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted private val workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {


    override suspend fun doWork(): Result {
        return try {
            val title = workerParams.inputData.getString(Constants.NOTIFICATION_TITLE)
                ?: "No title available"
            val message = workerParams.inputData.getString(Constants.NOTIFICATION_MESSAGE)
                ?: "No message available"

            // Send notification
            NotificationHelper.showNotification(
                applicationContext,
                title,
                message
            )
            Result.success()
        } catch (e: Exception) {
            // Handle exceptions
            Result.failure()
        }


    }
}