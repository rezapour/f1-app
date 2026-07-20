package me.rezapour.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DriverResponse(
    @SerialName("MRData") var mRData: MRDataDto? = MRDataDto(),
)

@Serializable
data class MRDataDto(
    var xmlns: String? = null,
    var series: String? = null,
    var url: String? = null,
    var limit: String? = null,
    var offset: String? = null,
    var total: String? = null,
    @SerialName("DriverTable") var driverTable: DriverTableDto? = DriverTableDto(),
)

@Serializable
data class DriverTableDto(
    @SerialName("Drivers") var drivers: ArrayList<DriverDto> = arrayListOf(),
)

@Serializable
data class DriverDto(
    var driverId: String,
    var url: String? = null,
    var givenName: String? = null,
    var familyName: String? = null,
    var dateOfBirth: String? = null,
    var nationality: String? = null,
)
