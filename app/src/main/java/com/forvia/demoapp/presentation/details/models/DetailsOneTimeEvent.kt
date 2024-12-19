package com.forvia.demoapp.presentation.details.models

sealed class DetailsOneTimeEvent {
    data object NavigateBack : DetailsOneTimeEvent()
}