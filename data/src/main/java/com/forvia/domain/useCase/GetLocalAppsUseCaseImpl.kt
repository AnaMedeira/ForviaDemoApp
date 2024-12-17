package com.forvia.domain.useCase

import com.forvia.domain.model.AppItem
import com.forvia.domain.repository.AppLocalRepository

class GetLocalAppsUseCaseImpl(private val repository: AppLocalRepository) : GetLocalAppsUseCase {
    override suspend fun invoke(): List<AppItem> {
        return repository.getApps()
    }

}