package me.rezapour.network

sealed class NetworkError(message: String? = null, cause: Throwable? = null) :
    Exception(message, cause) {

    class NoInternet(cause: Throwable? = null) :
        NetworkError("no internet Connection", cause)

    class HttpError(val code: Int, cause: Throwable? = null) :
        NetworkError("Http error $code", cause)

    class BodyIsCorrupted(cause: Throwable? = null) :
        NetworkError("The respond body is corrupted", cause)

    class Unauthorised(cause: Throwable? = null):NetworkError("Unauthorised access", cause)
}