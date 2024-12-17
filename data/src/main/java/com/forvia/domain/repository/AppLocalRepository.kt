package com.forvia.domain.repository

import com.forvia.domain.model.AppItem

interface AppLocalRepository {
    suspend fun getApps(): List<AppItem>
    suspend fun saveApps(appItem: AppItem)
}