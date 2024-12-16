package com.forvia.domain.repository

import com.forvia.domain.model.AppItem

interface AppRepository {
    suspend fun getApps(): List<AppItem>
}