package com.forvia.domain.useCase

import com.forvia.domain.model.AppItem
import com.forvia.domain.repository.AppRepository

class GetAppsUseCaseImpl(private val repository: AppRepository) : GetAppsUseCase {
    override suspend fun invoke(): List<AppItem> {
        return repository.getApps()
    }

}