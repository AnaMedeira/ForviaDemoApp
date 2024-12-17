package com.forvia.domain.useCase

import com.forvia.domain.model.AppItem
import com.forvia.domain.repository.AppRemoteRepository

class GetRemoteAppsUseCaseImpl(private val repository: AppRemoteRepository) : GetRemoteAppsUseCase {
    override suspend fun invoke(): List<AppItem> {
        return repository.getApps()
    }

}