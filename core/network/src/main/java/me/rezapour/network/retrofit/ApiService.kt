package me.rezapour.network.retrofit

import me.rezapour.network.model.DriverListNetworkEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("drivers")
    suspend fun getDrivers(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): DriverListNetworkEntity
}