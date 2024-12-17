package com.forvia.domain.useCase

import com.forvia.domain.model.AppItem

interface SaveLocalAppsUseCase {
    suspend operator fun invoke(list: List<AppItem>)
}