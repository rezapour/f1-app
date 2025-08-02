package me.rezapour.network

sealed class NetworkException(message: String? = null, cause: Throwable? = null) :
    Exception(message, cause) {

    class NoInternet(cause: Throwable? = null) :
        NetworkException("no internet Connection", cause)

    class HttpError(val code: Int, cause: Throwable? = null) :
        NetworkException("Http error $code", cause)

    class BodyIsCorrupted(cause: Throwable? = null) :
        NetworkException("The respond body is corrupted", cause)

    class Unauthorised(cause: Throwable? = null):NetworkException("Unauthorised access", cause)
}