package me.rezapour.network.model

import com.google.gson.annotations.SerializedName

data class DriverListNetworkEntity(
    @SerializedName("MRData") var mRData: MRDataNetworkEntity? = MRDataNetworkEntity()
)

data class MRDataNetworkEntity(
    @SerializedName("xmlns") var xmlns: String? = null,
    @SerializedName("series") var series: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("limit") var limit: String? = null,
    @SerializedName("offset") var offset: String? = null,
    @SerializedName("total") var total: String? = null,
    @SerializedName("DriverTable") var driverTable: DriverTableNetworkEntity? = DriverTableNetworkEntity()
)

data class DriverTableNetworkEntity(
    @SerializedName("Drivers") var drivers: ArrayList<DriversNetworkEntity> = arrayListOf()
)

data class DriversNetworkEntity(
    @SerializedName("driverId") var driverId: String,
    @SerializedName("url") var url: String? = null,
    @SerializedName("givenName") var givenName: String? = null,
    @SerializedName("familyName") var familyName: String? = null,
    @SerializedName("dateOfBirth") var dateOfBirth: String? = null,
    @SerializedName("nationality") var nationality: String? = null
)
