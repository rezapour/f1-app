package me.rezapour.domain.models

data class DriverDomain(
    val driverId: String? = null,
    val url: String? = null,
    val givenName: String? = null,
    val familyName: String? = null,
    val dateOfBirth: String? = null,
    val nationality: String? = null
)