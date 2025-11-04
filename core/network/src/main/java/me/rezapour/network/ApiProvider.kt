package me.rezapour.network

import me.rezapour.network.model.ConstructorsNetworkEntity
import me.rezapour.network.model.DriverListNetworkEntity

interface ApiProvider {
    suspend fun getDrivers(season: String, offset: Int, limit: Int): DriverListNetworkEntity

    suspend fun getConstructors(season: String, offset: Int, limit: Int): ConstructorsNetworkEntity
}