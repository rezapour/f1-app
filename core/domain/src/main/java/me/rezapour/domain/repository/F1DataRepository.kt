package me.rezapour.domain.repository

import me.rezapour.domain.models.ConstructorDomain
import me.rezapour.domain.models.DriverDomain

interface F1DataRepository {
    suspend fun getDrivers(): List<DriverDomain>

    suspend fun getConstructors(): List<ConstructorDomain>
}