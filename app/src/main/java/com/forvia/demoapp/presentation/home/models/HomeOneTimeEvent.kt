package com.forvia.demoapp.presentation.home.models

import com.forvia.domain.model.AppItem

sealed class HomeOneTimeEvent {
    data class NavigateToDetails(val item: AppItem) : HomeOneTimeEvent()
}