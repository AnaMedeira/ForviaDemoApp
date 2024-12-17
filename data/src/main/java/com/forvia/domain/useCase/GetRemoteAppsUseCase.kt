package com.forvia.domain.useCase

import com.forvia.domain.model.AppItem

interface GetRemoteAppsUseCase {
    suspend operator fun invoke(): List<AppItem>
}