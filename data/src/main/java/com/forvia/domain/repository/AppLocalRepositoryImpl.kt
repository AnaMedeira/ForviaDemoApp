package com.forvia.domain.repository

import com.forvia.domain.database.AppDao
import com.forvia.domain.mapper.toAppTable
import com.forvia.domain.model.AppItem

class AppLocalRepositoryImpl(private val dao: AppDao) : AppLocalRepository {
    override suspend fun getApps(): List<AppItem> {
        //Missing error scenarios
        return dao.getAllApps().map { it.toAppTable() } ?: emptyList()
    }

    override suspend fun saveApps(appItem: AppItem) {
        dao.saveApps(appItem.toAppTable())
    }


}