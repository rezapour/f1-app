package me.rezapour.data.repository

import kotlinx.coroutines.withContext
import me.rezapour.common.dispatcher.CoroutineDispatcherProvider
import me.rezapour.data.mapper.ExceptionMapper
import me.rezapour.data.mapper.F1NetworkMapper
import me.rezapour.domain.error.DomainException
import me.rezapour.domain.models.DriverDomain
import me.rezapour.domain.repository.F1DataRepository
import me.rezapour.network.ApiProvider
import javax.inject.Inject

class F1DataRepositoryImpl @Inject constructor(
    private val api: ApiProvider,
    private val dispatcher: CoroutineDispatcherProvider,
    private val mapper: F1NetworkMapper
) : F1DataRepository {
    override suspend fun getDrivers(): List<DriverDomain> = withContext(dispatcher.io) {
        return@withContext runCatching {
            val drivers = api.getDrivers(0, 30).mRData?.driverTable?.drivers
                ?: throw DomainException.GeneralException()
            mapper.driverMapper.map(drivers)
        }.getOrElse { e ->
            throw ExceptionMapper.toDomainException(e)
        }
    }
}