package me.rezapour.common.dispatcher.impl

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import me.rezapour.common.dispatcher.CoroutineDispatcherProvider
import javax.inject.Inject

class DefaultCoroutineDispatcherImpl @Inject constructor() : CoroutineDispatcherProvider {
    override val main: CoroutineDispatcher = Dispatchers.Main
    override val io: CoroutineDispatcher = Dispatchers.IO
    override val default: CoroutineDispatcher = Dispatchers.Default
}