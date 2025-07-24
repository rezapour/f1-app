package me.rezapour.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DriverListNetworkEntity(
    @Expose @SerializedName("MRData") var mRData: MRDataNetworkEntity? = MRDataNetworkEntity()
)

data class MRDataNetworkEntity(
    @Expose @SerializedName("xmlns") var xmlns: String? = null,
    @Expose @SerializedName("series") var series: String? = null,
    @Expose @SerializedName("url") var url: String? = null,
    @Expose @SerializedName("limit") var limit: String? = null,
    @Expose @SerializedName("offset") var offset: String? = null,
    @Expose @SerializedName("total") var total: String? = null,
    @Expose @SerializedName("DriverTable") var driverTable: DriverTableNetworkEntity? = DriverTableNetworkEntity()
)

data class DriverTableNetworkEntity(
    @Expose @SerializedName("Drivers") var drivers: ArrayList<DriversNetworkEntity> = arrayListOf()
)

data class DriversNetworkEntity(
    @Expose @SerializedName("driverId") var driverId: String? = null,
    @Expose @SerializedName("url") var url: String? = null,
    @Expose @SerializedName("givenName") var givenName: String? = null,
    @Expose @SerializedName("familyName") var familyName: String? = null,
    @Expose @SerializedName("dateOfBirth") var dateOfBirth: String? = null,
    @Expose @SerializedName("nationality") var nationality: String? = null
)
