package com.forvia.domain.useCase

import com.forvia.domain.model.AppItem
import com.forvia.domain.utils.NetworkUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAppsUseCaseImpl(
    private val networkUtils: NetworkUtils,
    private val remoteAppsUseCase: GetRemoteAppsUseCase,
    private val localAppsUseCase: GetLocalAppsUseCase,
    private val saveLocalAppsUseCase: SaveLocalAppsUseCase
) : GetAppsUseCase {
    override suspend fun getApps(): List<AppItem> {
        return withContext(Dispatchers.IO) {
            if (networkUtils.isInternetAvailable()) {
                try {
                    // Fetch data from API
                    val remoteApps = remoteAppsUseCase.invoke()
                    // Cache data into Room database
                    saveLocalAppsUseCase.invoke(remoteApps)
                    remoteApps
                } catch (e: Exception) {
                    // In case of an API failure, fallback to DB
                    localAppsUseCase.invoke()
                }
            } else {
                // No internet, fetch data from local database
                localAppsUseCase.invoke()
            }
        }
    }

    override suspend fun getNewApps(): Int {
        TODO("Not yet implemented")
    }
}