package me.rezapour.data.pagin

import androidx.paging.PagingSource
import androidx.paging.PagingState
import me.rezapour.data.mapper.Mapper
import me.rezapour.domain.models.Driver
import me.rezapour.network.ApiProvider
import me.rezapour.network.NetworkException
import me.rezapour.network.model.DriverDto
import java.io.IOException

class DriverListPagingSource(
    private val api: ApiProvider,
    private val mapper: Mapper<DriverDto, Driver>,
) : PagingSource<Int, Driver>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Driver> {

        try {
            var currentOffset = params.key ?: 0
            val response = api.getDrivers(offset = currentOffset, limit = params.loadSize)
            val drivers = mapper.map(
                response.mRData?.driverTable?.drivers
                    ?: throw IOException("Drivers is null")
            )
            currentOffset += params.loadSize
            val total: Int = response.mRData?.total?.toInt() ?: 0
            return LoadResult.Page(
                data = drivers,
                prevKey = null,
                nextKey = if (currentOffset >= total) null else currentOffset
            )

        } catch (e: NetworkException.Unauthorised) {
            return LoadResult.Error(e)
        } catch (e: NetworkException.HttpError) {
            return LoadResult.Error(e)
        } catch (e: IOException) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Driver>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(state.config.pageSize)
                ?: anchorPage?.nextKey?.minus(state.config.pageSize)
        }
    }
}