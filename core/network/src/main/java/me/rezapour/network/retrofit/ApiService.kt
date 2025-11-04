package me.rezapour.network.retrofit

import me.rezapour.network.model.ConstructorsNetworkEntity
import me.rezapour.network.model.DriverListNetworkEntity
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("{season}/drivers")
    suspend fun getDrivers(
        @Path("season") season: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): DriverListNetworkEntity


    @GET("{season}/constructors/")
    suspend fun getConstructors(
        @Path("season") season: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): ConstructorsNetworkEntity
}