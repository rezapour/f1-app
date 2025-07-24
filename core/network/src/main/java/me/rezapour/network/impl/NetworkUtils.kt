package me.rezapour.network.impl

import com.google.gson.JsonSyntaxException
import me.rezapour.network.NetworkError
import retrofit2.HttpException

inline fun <T> safeApiCall(block: () -> T): T {
    try {
        return block()
    } catch (e: HttpException) {
        throw when (e.code()) {
            401 -> NetworkError.Unauthorised()
            else -> NetworkError.HttpError(e.code())
        }
    } catch (e: JsonSyntaxException) {
        throw NetworkError.BodyIsCorrupted()
    } catch (e: Exception) {
        throw NetworkError.NoInternet(e)
    }
}