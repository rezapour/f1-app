package me.rezapour.network.impl

import me.rezapour.network.ApiProvider
import me.rezapour.network.model.ConstructorsNetworkEntity
import me.rezapour.network.model.DriverListNetworkEntity
import me.rezapour.network.retrofit.ApiService
import javax.inject.Inject

class ApiProviderRetrofitImpl @Inject constructor(private val api: ApiService) : ApiProvider {
    override suspend fun getDrivers(
        season: String,
        offset: Int,
        limit: Int
    ): DriverListNetworkEntity =
        safeApiCall {
            api.getDrivers(season = season, offset = offset, limit = limit)
        }

    override suspend fun getConstructors(
        season: String,
        offset: Int,
        limit: Int
    ): ConstructorsNetworkEntity =
        safeApiCall {
            api.getConstructors(season = season, offset = offset, limit = limit)
        }

}