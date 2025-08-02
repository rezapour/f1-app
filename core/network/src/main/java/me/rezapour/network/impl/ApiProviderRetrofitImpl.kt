package me.rezapour.network.impl

import me.rezapour.network.ApiProvider
import me.rezapour.network.model.DriverListNetworkEntity
import me.rezapour.network.retrofit.ApiService
import javax.inject.Inject

class ApiProviderRetrofitImpl @Inject constructor(private val api: ApiService) : ApiProvider {
    override suspend fun getDrivers(offset: Int, limit: Int): DriverListNetworkEntity =
        safeApiCall {
            api.getDrivers(offset = offset, limit = limit)
        }
}