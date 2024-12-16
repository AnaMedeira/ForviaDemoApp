package com.forvia.domain.repository

import com.forvia.domain.api.AppApi
import com.forvia.domain.mapper.toDomain
import com.forvia.domain.model.AppItem

class AppRepositoryImpl(private val api: AppApi) : AppRepository {
    override suspend fun getApps(): List<AppItem> {
        //Missing error scenarios
        return api.getAppList().responses?.listApps?.datasets?.all?.data?.list?.map { it.toDomain() }
            ?: emptyList()
    }
}