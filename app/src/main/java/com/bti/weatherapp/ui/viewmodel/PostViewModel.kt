package com.bti.weatherapp.ui.viewmodel

import com.bti.weatherapp.domain.usecase.GetPostUseCase
import com.bti.weatherapp.domain.usecase.RefreshPostUseCase
import com.bti.weatherapp.domain.usecase.GetCounterPreferenceValueUseCase
import kotlinx.coroutines.flow.collectLatest
import com.bti.weatherapp.domain.utils.ResourceState
import com.bti.weatherapp.utils.UiState
import com.bti.weatherapp.domain.entities.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class PostViewModel @Inject constructor(
    private val getPostUseCase: GetPostUseCase,
    private val refreshPostUseCase: RefreshPostUseCase,
    private val getCounterPreferenceValueUseCase: GetCounterPreferenceValueUseCase,
) : ViewModel() {

    init {
        getPost()
        getCounterPreferenceValue()
    }

    private val _demoUiStates = MutableStateFlow<UiState<Post>>(UiState.Loading)
    val demoUiStates: StateFlow<UiState<Post>> = _demoUiStates.asStateFlow()

    private fun getPost() {
        viewModelScope.launch(Dispatchers.IO) {
            getPostUseCase().collect { response ->
                when (response) {
                    is ResourceState.Failure -> {
                        _demoUiStates.emit(UiState.Failure(Throwable(response.throwable)))
                    }

                    is ResourceState.Success -> {
                        _demoUiStates.emit(UiState.Success(data = response.data))
                    }
                }
            }
        }
        viewModelScope.launch(Dispatchers.IO) {
            refreshPostUseCase()
        }
    }

    private fun getCounterPreferenceValue() {
        viewModelScope.launch {
            getCounterPreferenceValueUseCase.invoke().collectLatest { counterValue ->
                println("Counter Default value is $counterValue")
            }
        }
    }
}