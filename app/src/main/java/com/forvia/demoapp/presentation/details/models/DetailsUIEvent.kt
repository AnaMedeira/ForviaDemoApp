package com.forvia.demoapp.presentation.details.models

sealed class DetailsUIEvent {
    data object ShowDialog : DetailsUIEvent()
    data object DismissDialog : DetailsUIEvent()
    data object NavigateBack : DetailsUIEvent()
}