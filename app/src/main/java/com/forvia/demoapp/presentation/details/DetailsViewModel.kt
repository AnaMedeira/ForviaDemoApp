package com.forvia.demoapp.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.forvia.demoapp.presentation.details.models.DetailsOneTimeEvent
import com.forvia.demoapp.presentation.details.models.DetailsUIEvent
import com.forvia.demoapp.presentation.details.models.DetailsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor() : ViewModel() {

    private val _uiStateFlow = MutableStateFlow(DetailsUiState())
    val uiStateFlow: StateFlow<DetailsUiState> = _uiStateFlow.asStateFlow()

    private val _oneTimeEventChannel = Channel<DetailsOneTimeEvent>()
    val oneTimeEvents = _oneTimeEventChannel.receiveAsFlow()

    init {
        viewModelScope.launch {
            _uiStateFlow.value = DetailsUiState(showDialog = false)
        }
    }

    fun dispatch(event: DetailsUIEvent) {
        when (event) {
            DetailsUIEvent.ShowDialog -> _uiStateFlow.value = DetailsUiState(showDialog = true)
            DetailsUIEvent.DismissDialog -> _uiStateFlow.value = DetailsUiState(showDialog = false)
            DetailsUIEvent.NavigateBack -> sendOneTimeEvent(DetailsOneTimeEvent.NavigateBack)
        }
    }

    private fun sendOneTimeEvent(event: DetailsOneTimeEvent) {
        viewModelScope.launch {
            _oneTimeEventChannel.send(event)
        }
    }

}