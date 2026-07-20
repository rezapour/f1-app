package me.rezapour.network.di


import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.rezapour.network.ApiProvider
import me.rezapour.network.impl.ApiProviderRetrofitImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkBindingModule {

    @Singleton
    @Binds
    abstract fun provideNetworkApiProvider(impl: ApiProviderRetrofitImpl): ApiProvider

}
