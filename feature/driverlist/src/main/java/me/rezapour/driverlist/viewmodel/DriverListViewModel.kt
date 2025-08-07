package me.rezapour.driverlist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import me.rezapour.domain.models.DriverDomain
import me.rezapour.domain.usecase.DriverUseCase
import me.rezapour.driverlist.UIState
import javax.inject.Inject

@HiltViewModel
class DriverListViewModel @Inject constructor(
    private val driverUseCase: DriverUseCase
) :
    ViewModel() {

    private val _uiState: MutableStateFlow<UIState<List<DriverDomain>>> =
        MutableStateFlow(UIState.Loading)

    val uiState: StateFlow<UIState<List<DriverDomain>>> = _uiState.asStateFlow()


    init {
        viewModelScope.launch {
            runCatching {
                driverUseCase()
            }.getOrElse {
                //todo handle error
                _uiState.value = UIState.Error(it.message.toString())
            }

            driverUseCase.driversFlow.collect {
                _uiState.value = UIState.Success(it)
            }
        }
    }
}
