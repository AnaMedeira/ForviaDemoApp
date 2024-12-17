package com.forvia.domain.repository

import com.forvia.domain.model.AppItem

interface AppRemoteRepository {
    suspend fun getApps(): List<AppItem>
}