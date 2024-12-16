package com.forvia.demoapp.presentation.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.forvia.demoapp.util.Constants.APP_DETAILS_ID
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    //parameter to search the app on the list
    val args: String = checkNotNull(savedStateHandle[APP_DETAILS_ID] ?: "")
}