package me.rezapour.domain.usecase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import me.rezapour.domain.models.Driver
import me.rezapour.domain.repository.F1DataRepository
import javax.inject.Inject

class DriverUseCase @Inject constructor(private val repository: F1DataRepository) {

    operator fun invoke(): Flow<PagingData<Driver>> =
        repository.getDrivers()
}