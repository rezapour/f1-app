package me.rezapour.di.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.rezapour.data.di.MapperModule
import me.rezapour.data.repository.F1DataRepositoryImpl
import me.rezapour.domain.repository.F1DataRepository
import javax.inject.Singleton

@Module(
    includes = [MapperModule::class]
)
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindF1DataRepository(impl: F1DataRepositoryImpl): F1DataRepository
}