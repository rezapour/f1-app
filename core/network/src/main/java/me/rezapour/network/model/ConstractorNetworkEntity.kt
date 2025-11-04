package me.rezapour.network.model

import com.google.gson.annotations.SerializedName

class ConstructorsNetworkEntity {
    @SerializedName("MRData")
    var MRData: MRDataConstructorsNetworkEntity? = MRDataConstructorsNetworkEntity()
}

data class MRDataConstructorsNetworkEntity(

    @SerializedName("xmlns") var xmlns: String? = null,
    @SerializedName("series") var series: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("limit") var limit: String? = null,
    @SerializedName("offset") var offset: String? = null,
    @SerializedName("total") var total: String? = null,
    @SerializedName("ConstructorTable") var ConstructorTable: ConstructorTable? = ConstructorTable()

)

data class ConstructorTable(
    @SerializedName("season") var season: String? = null,
    @SerializedName("Constructors") var Constructors: List<ConstructorNetworkEntity> = arrayListOf()
)

data class ConstructorNetworkEntity(
    @SerializedName("constructorId") var constructorId: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("name") var name: String,
    @SerializedName("nationality") var nationality: String? = null
)

