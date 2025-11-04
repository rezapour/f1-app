package me.rezapour.network.impl

import com.google.gson.JsonSyntaxException
import me.rezapour.network.NetworkException
import retrofit2.HttpException

inline fun <T> safeApiCall(block: () -> T): T {
    try {
        return block()
    } catch (e: HttpException) {
        throw when (e.code()) {
            401 -> NetworkException.Unauthorised()
            else -> NetworkException.HttpError(e.code())
        }
    } catch (e: JsonSyntaxException) {
        throw NetworkException.BodyIsCorrupted()
    } catch (e: Exception) {
        throw NetworkException.NoInternet(e)
    }
}