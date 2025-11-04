package me.rezapour.constructors.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import me.rezapour.domain.models.ConstructorDomain
import me.rezapour.domain.usecase.ConstructorUseCase
import javax.inject.Inject

@HiltViewModel
class ConstructorsListViewModel @Inject constructor(private val constructorUseCase: ConstructorUseCase) :
    ViewModel() {

    private val _uiState: MutableStateFlow<ConstructorUiState> =
        MutableStateFlow(ConstructorUiState())

    val uiState: StateFlow<ConstructorUiState> = _uiState.asStateFlow()


    fun getConstructors() {
        viewModelScope.launch {
            runCatching {
                success(constructorUseCase.invoke())
            }.getOrElse {
                error()
            }
        }
    }

    private fun success(constructors: List<ConstructorDomain>) {
        _uiState.update {
            _uiState.value.copy(
                constructors = constructors,
                error = false,
                isLoading = false
            )
        }
    }

    private fun error() {
        _uiState.update {
            _uiState.value.copy(
                error = true,
                isLoading = false
            )
        }
    }

    fun intent(message: String) {
        _uiState.update {
            _uiState.value.copy(
                text = message
            )
        }
    }
}


data class ConstructorUiState(
    var constructors: List<ConstructorDomain> = mutableListOf<ConstructorDomain>(),
    var error: Boolean = false,
    var isLoading: Boolean = false,
    var text: String = ""
)