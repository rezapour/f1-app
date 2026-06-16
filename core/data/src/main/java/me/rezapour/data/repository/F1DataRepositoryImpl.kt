package me.rezapour.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import me.rezapour.common.dispatcher.CoroutineDispatcherProvider
import me.rezapour.data.mapper.ExceptionMapper
import me.rezapour.data.mapper.F1NetworkMapper
import me.rezapour.data.pagin.DriverListPagingSource
import me.rezapour.domain.error.DomainException
import me.rezapour.domain.models.ConstructorDomain
import me.rezapour.domain.models.Driver
import me.rezapour.domain.repository.F1DataRepository
import me.rezapour.network.ApiProvider
import javax.inject.Inject

class F1DataRepositoryImpl @Inject constructor(
    private val api: ApiProvider,
    private val dispatcher: CoroutineDispatcherProvider,
    private val mapper: F1NetworkMapper,
) : F1DataRepository {
    override  fun getDrivers(): Flow<PagingData<Driver>> {
        return Pager(
            config = PagingConfig(
                pageSize = 30,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                DriverListPagingSource(
                    api = api,
                    mapper = mapper.driverMapper
                )
            }
        ).flow
    }

    override suspend fun getConstructors(): List<ConstructorDomain> = withContext(dispatcher.io) {
        return@withContext runCatching {
            val constructors =
                api.getConstructors("2025", 0, 30).MRData?.ConstructorTable?.Constructors
                    ?: throw DomainException.GeneralException()
            mapper.constructorMapper.map(constructors)
        }.getOrElse { e ->
            throw ExceptionMapper.toDomainException(e)
        }
    }
}