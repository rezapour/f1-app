package me.rezapour.domain.usecase

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import me.rezapour.domain.models.DriverDomain
import me.rezapour.domain.repository.F1DataRepository
import javax.inject.Inject

class DriverUseCase @Inject constructor(private val repository: F1DataRepository) {

    private val _driversFlow: MutableStateFlow<List<DriverDomain>> = MutableStateFlow(emptyList())
    val driversFlow: StateFlow<List<DriverDomain>> = _driversFlow.asStateFlow()


    suspend operator fun invoke() {
        val drivers = repository.getDrivers()
        _driversFlow.value = drivers
    }


}