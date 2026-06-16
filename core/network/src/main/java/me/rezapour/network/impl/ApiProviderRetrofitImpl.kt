package me.rezapour.network.impl

import com.google.gson.JsonSyntaxException
import me.rezapour.network.ApiProvider
import me.rezapour.network.NetworkException
import me.rezapour.network.model.ConstructorsNetworkEntity
import me.rezapour.network.model.DriverResponse
import me.rezapour.network.retrofit.ApiService
import retrofit2.HttpException
import javax.inject.Inject

class ApiProviderRetrofitImpl @Inject constructor(private val api: ApiService) : ApiProvider {
    override suspend fun getDrivers(
        offset: Int,
        limit: Int,
    ): DriverResponse =
        safeApiCall {
            api.getDrivers(offset = offset, limit = limit)
        }

    override suspend fun getConstructors(
        season: String,
        offset: Int,
        limit: Int,
    ): ConstructorsNetworkEntity =
        safeApiCall {
            api.getConstructors(season = season, offset = offset, limit = limit)
        }

}


private suspend fun <T> safeApiCall(block: suspend () -> T): T {
    try {
        return block()
    } catch (e: HttpException) {
        throw when (e.code()) {
            401 -> NetworkException.Unauthorised()
            else -> NetworkException.HttpError(e.code())
        }
    } catch (e: JsonSyntaxException) {
        throw NetworkException.BodyIsCorrupted(e)
    } catch (e: Exception) {
        throw NetworkException.NoInternet(e)
    }
}