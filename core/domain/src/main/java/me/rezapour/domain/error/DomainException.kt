package me.rezapour.domain.error

sealed class DomainException(message: String? = null, throwable: Throwable? = null) :
    Exception(message, throwable) {

    class InternetIssue(throwable: Throwable? = null) :
        DomainException("There is an internet issue.", throwable)

    class GeneralException(throwable: Throwable? = null) :
        DomainException("Something went wrong.", throwable)

    class Unauthorised(throwable: Throwable? = null) :
        DomainException("Unauthorised", throwable)
}