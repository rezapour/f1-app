package me.rezapour.data.mapper

import me.rezapour.domain.error.DomainException
import me.rezapour.network.NetworkException

object ExceptionMapper {
    fun toDomainException(e: Throwable) = when (e) {
        is NetworkException.HttpError -> DomainException.InternetIssue(e)
        is NetworkException.NoInternet -> DomainException.InternetIssue(e)
        is NetworkException.BodyIsCorrupted -> DomainException.InternetIssue(e)
        is NetworkException.Unauthorised -> DomainException.Unauthorised(e)
        else -> DomainException.GeneralException(e)
    }
}