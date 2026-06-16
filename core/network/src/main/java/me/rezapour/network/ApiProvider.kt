package me.rezapour.network

import me.rezapour.network.model.ConstructorsNetworkEntity
import me.rezapour.network.model.DriverResponse

interface ApiProvider {
    suspend fun getDrivers(offset: Int, limit: Int): DriverResponse

    suspend fun getConstructors(season: String, offset: Int, limit: Int): ConstructorsNetworkEntity
}