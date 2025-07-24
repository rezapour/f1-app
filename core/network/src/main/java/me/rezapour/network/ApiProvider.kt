package me.rezapour.network

import me.rezapour.network.model.DriverListNetworkEntity

interface ApiProvider {
    suspend fun getDrivers(offset: Int, limit: Int): DriverListNetworkEntity
}