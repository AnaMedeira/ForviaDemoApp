package com.forvia.demoapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.forvia.demoapp.presentation.home.models.HomeOneTimeEvent
import com.forvia.demoapp.presentation.home.models.HomeUIEvent
import com.forvia.demoapp.presentation.home.models.HomeUiState
import com.forvia.domain.useCase.GetAppsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val getAppsUseCase: GetAppsUseCase
) : ViewModel() {


    private val _uiStateFlow = MutableStateFlow(HomeUiState(true))
    val uiStateFlow: StateFlow<HomeUiState> = _uiStateFlow.asStateFlow()

    private val _oneTimeEventChannel = Channel<HomeOneTimeEvent>()
    val oneTimeEvents = _oneTimeEventChannel.receiveAsFlow()


    init {
        viewModelScope.launch {
            _uiStateFlow.value = HomeUiState(false, appList = getAppsUseCase.invoke())
        }
    }

    fun dispatch(event: HomeUIEvent) {
        when (event) {
            is HomeUIEvent.SelectApp -> sendOneTimeEvent(HomeOneTimeEvent.NavigateToDetails(event.appItem))
        }
    }

    private fun sendOneTimeEvent(event: HomeOneTimeEvent) {
        viewModelScope.launch {
            _oneTimeEventChannel.send(event)
        }
    }
}