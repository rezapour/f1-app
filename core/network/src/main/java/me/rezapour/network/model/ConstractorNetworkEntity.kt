package me.rezapour.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ConstructorsNetworkEntity {
    @SerialName("MRData")
    var mrData: MRDataConstructorsNetworkEntity? = MRDataConstructorsNetworkEntity()
}

@Serializable
data class MRDataConstructorsNetworkEntity(

    var xmlns: String? = null,
    var series: String? = null,
    var url: String? = null,
    var limit: String? = null,
    var offset: String? = null,
    var total: String? = null,
    @SerialName("ConstructorTable") var constructorTable: ConstructorTable? = ConstructorTable(),

    )

@Serializable
data class ConstructorTable(
    var season: String? = null,
    @SerialName("Constructors") var constructors: List<ConstructorNetworkEntity> = arrayListOf(),
)

@Serializable
data class ConstructorNetworkEntity(
    var constructorId: String? = null,
    var url: String? = null,
    var name: String,
    var nationality: String? = null,
)

