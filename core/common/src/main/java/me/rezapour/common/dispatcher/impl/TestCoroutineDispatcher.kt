package me.rezapour.common.dispatcher.impl

import kotlinx.coroutines.CoroutineDispatcher
import me.rezapour.common.dispatcher.CoroutineDispatcherProvider

class TestCoroutineDispatcher(
    testDispatcher: CoroutineDispatcher,
) : CoroutineDispatcherProvider {
    override val main: CoroutineDispatcher = testDispatcher
    override val io: CoroutineDispatcher = testDispatcher
    override val default: CoroutineDispatcher = testDispatcher
}