package me.rezapour.data.mapper

import me.rezapour.domain.models.DriverDomain
import me.rezapour.network.model.DriversNetworkEntity
import javax.inject.Inject

class DriverNetworkMapper @Inject constructor() : Mapper<DriversNetworkEntity, DriverDomain> {
    override fun map(input: DriversNetworkEntity): DriverDomain =
        DriverDomain(
            driverId = requireNotNull(input.driverId) { "driverId cannot be null" },
            url = input.url ?: "",
            givenName = input.givenName ?: "Unknown",
            familyName = input.familyName ?: "Unknown",
            dateOfBirth = input.dateOfBirth ?: "",
            nationality = input.nationality ?: ""
        )


    override fun map(inputs: List<DriversNetworkEntity>): List<DriverDomain> =
        inputs.map { map(it) }

}