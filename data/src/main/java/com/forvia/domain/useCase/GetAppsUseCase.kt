package com.forvia.domain.useCase

import com.forvia.domain.model.AppItem

interface GetAppsUseCase {
    suspend operator fun invoke(): List<AppItem>
}