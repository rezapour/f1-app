package me.rezapour.network.retrofit

import me.rezapour.network.model.ConstructorsNetworkEntity
import me.rezapour.network.model.DriverResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("drivers")
    suspend fun getDrivers(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): DriverResponse


    @GET("{season}/constructors/")
    suspend fun getConstructors(
        @Path("season") season: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): ConstructorsNetworkEntity
}