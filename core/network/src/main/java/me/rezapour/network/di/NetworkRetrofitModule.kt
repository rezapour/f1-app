package me.rezapour.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.rezapour.network.constance.NetworkConstance
import me.rezapour.network.retrofit.ApiService
import me.rezapour.network.retrofit.client.RetrofitClient
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkRetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofitClient(): Retrofit =
        RetrofitClient.getInstance(NetworkConstance.BASE_URL, NetworkConstance.TIME_OUT)

    @Singleton
    @Provides
    fun provideNetworkApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}

