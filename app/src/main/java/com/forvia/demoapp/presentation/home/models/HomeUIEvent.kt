package com.forvia.demoapp.presentation.home.models

import com.forvia.domain.model.AppItem

sealed class HomeUIEvent {
    data class SelectApp(val appItem: AppItem) : HomeUIEvent()
}
