package me.rezapour.data.mapper

import me.rezapour.domain.models.DriverDomain
import me.rezapour.network.model.DriversNetworkEntity
import javax.inject.Inject

class DriverNetworkMapper @Inject constructor() : Mapper<DriversNetworkEntity, DriverDomain> {
    override fun map(input: DriversNetworkEntity): DriverDomain =
        DriverDomain(
            driverId = input.driverId,
            url = input.url,
            givenName = input.givenName,
            familyName = input.familyName,
            dateOfBirth = input.dateOfBirth,
            nationality = input.nationality
        )


    override fun map(inputs: List<DriversNetworkEntity>): List<DriverDomain> =
        inputs.map { map(it) }

}