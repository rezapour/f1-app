package me.rezapour.data.mapper

import me.rezapour.domain.models.Driver
import me.rezapour.network.model.DriverDto
import javax.inject.Inject

class DriverNetworkMapper @Inject constructor() : Mapper<DriverDto, Driver> {
    override fun map(input: DriverDto): Driver =
        Driver(
            driverId = requireNotNull(input.driverId) { "driverId cannot be null" },
            url = input.url ?: "",
            givenName = input.givenName ?: "Unknown",
            familyName = input.familyName ?: "Unknown",
            dateOfBirth = input.dateOfBirth ?: "",
            nationality = input.nationality ?: ""
        )


    override fun map(inputs: List<DriverDto>): List<Driver> =
        inputs.map { map(it) }

}