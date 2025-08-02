package me.rezapour.common.dispatcher.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.rezapour.common.dispatcher.CoroutineDispatcherProvider
import me.rezapour.common.dispatcher.impl.DefaultCoroutineDispatcherImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CoroutineDispatcherModule {

    @Binds
    @Singleton
    abstract fun coroutineDispatcherBind(imp: DefaultCoroutineDispatcherImpl):
            CoroutineDispatcherProvider

}