package me.rezapour.data.mapper

import me.rezapour.domain.models.ConstructorDomain
import me.rezapour.domain.models.DriverDomain
import me.rezapour.network.model.ConstructorNetworkEntity
import me.rezapour.network.model.DriversNetworkEntity
import javax.inject.Inject

class F1NetworkMapper @Inject constructor(
    val driverMapper: Mapper<DriversNetworkEntity, DriverDomain>,
    val constructorMapper: Mapper<ConstructorNetworkEntity, ConstructorDomain>
)