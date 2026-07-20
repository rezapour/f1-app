package me.rezapour.drivers.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import me.rezapour.domain.usecase.DriverUseCase
import javax.inject.Inject

@HiltViewModel
class DriverListViewModel @Inject constructor(
    private val driverUseCase: DriverUseCase,
) : ViewModel() {

    val drivers = driverUseCase()
        .cachedIn(viewModelScope)
}







