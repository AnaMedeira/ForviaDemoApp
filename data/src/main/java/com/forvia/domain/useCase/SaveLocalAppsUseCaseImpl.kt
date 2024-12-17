package com.forvia.domain.useCase

import com.forvia.domain.model.AppItem
import com.forvia.domain.repository.AppLocalRepository

class SaveLocalAppsUseCaseImpl(private val repository: AppLocalRepository) : SaveLocalAppsUseCase {

    override suspend fun invoke(list: List<AppItem>) {
        list.forEach {
            repository.saveApps(it)
        }
    }

}