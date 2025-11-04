package me.rezapour.drivers.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import me.rezapour.domain.models.DriverDomain
import me.rezapour.domain.usecase.DriverUseCase
import javax.inject.Inject

@HiltViewModel
class DriverListViewModel @Inject constructor(
    private val driverUseCase: DriverUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<UIState> =
        MutableStateFlow(UIState())

    val uiState: StateFlow<UIState> = _uiState.asStateFlow()


    init {
        viewModelScope.launch {
            runCatching {

                driverUseCase()
            }.getOrElse {
                onError(it)
            }

            driverUseCase.driversFlow.collect {
                onSuccess(it)
            }
        }
    }

    private fun onSuccess(drivers: List<DriverDomain>) {
        _uiState.update {
            _uiState.value.copy(
                drivers = drivers,
                isLoading = false,
                error = false,
                message = null
            )
        }
    }

    private fun onError(error: Throwable) {
        _uiState.update {
            _uiState.value.copy(
                isLoading = false,
                error = true,
                message = error.message
            )
        }
    }
}

data class UIState(
    var drivers: List<DriverDomain> = mutableListOf(),
    var isLoading: Boolean = true,
    val error: Boolean = false,
    var message: String? = null
)


