package com.forvia.domain.useCase

import com.forvia.domain.model.AppItem

interface GetAppsUseCase {
    suspend fun getApps(): List<AppItem>
    suspend fun getNewApps(): Int
}