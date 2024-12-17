package com.forvia.domain.useCase

import com.forvia.domain.model.AppItem

interface GetLocalAppsUseCase {
    suspend operator fun invoke(): List<AppItem>
}