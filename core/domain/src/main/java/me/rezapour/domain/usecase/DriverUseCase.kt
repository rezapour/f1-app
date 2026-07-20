package me.rezapour.domain.usecase

import android.util.Log
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import me.rezapour.domain.models.Driver
import me.rezapour.domain.repository.F1DataRepository
import javax.inject.Inject

class DriverUseCase @Inject constructor(private val repository: F1DataRepository) {

    operator fun invoke(): Flow<PagingData<Driver>> =
        repository.getDrivers().map {
            it.map {
                Log.d("DriverUseCase", "invoke: $it")
                it
            }
        }
}