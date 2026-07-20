package me.rezapour.data.mapper

import me.rezapour.domain.models.ConstructorDomain
import me.rezapour.network.model.ConstructorNetworkEntity
import javax.inject.Inject

class ConstructorNetworkMapper @Inject constructor() :
    Mapper<ConstructorNetworkEntity, ConstructorDomain> {
    override fun map(input: ConstructorNetworkEntity): ConstructorDomain =
        ConstructorDomain(
            constructorId = requireNotNull(input.constructorId) { "constructorId can not be null" },
            name = input.name,
            url = input.url ?: "",
            nationality = input.nationality ?: ""
        )

    override fun map(inputs: List<ConstructorNetworkEntity>): List<ConstructorDomain> =
        inputs.map {constructor -> map(constructor) }

}