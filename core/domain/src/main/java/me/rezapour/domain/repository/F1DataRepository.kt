package me.rezapour.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import me.rezapour.domain.models.ConstructorDomain
import me.rezapour.domain.models.Driver

interface F1DataRepository {
    fun getDrivers(): Flow<PagingData<Driver>>

    suspend fun getConstructors(): List<ConstructorDomain>
}