package me.rezapour.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.rezapour.data.mapper.ConstructorNetworkMapper
import me.rezapour.data.mapper.DriverNetworkMapper
import me.rezapour.data.mapper.Mapper
import me.rezapour.domain.models.ConstructorDomain
import me.rezapour.domain.models.DriverDomain
import me.rezapour.network.model.ConstructorNetworkEntity
import me.rezapour.network.model.DriversNetworkEntity
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {


    @Binds
    @Singleton
    abstract fun bindDriverNetworkMapper(impl: DriverNetworkMapper):
            Mapper<DriversNetworkEntity, DriverDomain>

    @Binds
    @Singleton
    abstract fun bindConstructorNetworkMapper(impl: ConstructorNetworkMapper):
            Mapper<ConstructorNetworkEntity, ConstructorDomain>

}