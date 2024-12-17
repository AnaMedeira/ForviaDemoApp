package com.forvia.demoapp.presentation.home.models

import com.forvia.domain.model.AppItem

data class HomeUiState(
    val appList: List<AppItem> = emptyList()
)
