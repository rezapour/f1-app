package me.rezapour.domain.models

data class Driver(
    val driverId: String,
    val url: String,
    val givenName: String,
    val familyName: String,
    val dateOfBirth: String,
    val nationality: String
)