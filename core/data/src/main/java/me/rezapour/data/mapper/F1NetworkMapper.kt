package me.rezapour.data.mapper

import me.rezapour.domain.models.ConstructorDomain
import me.rezapour.domain.models.Driver
import me.rezapour.network.model.ConstructorNetworkEntity
import me.rezapour.network.model.DriverDto
import javax.inject.Inject

class F1NetworkMapper @Inject constructor(
    val driverMapper: Mapper<DriverDto, Driver>,
    val constructorMapper: Mapper<ConstructorNetworkEntity, ConstructorDomain>
)