package me.rezapour.domain.repository

import me.rezapour.domain.models.DriverDomain

interface F1DataRepository {
    suspend fun getDrivers():List<DriverDomain>

}