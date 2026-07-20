package me.rezapour.network.retrofit.client

import kotlinx.serialization.json.Json
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    fun getInstance(
        baseUrl: String,
        timeOut: Long,
    ): Retrofit {
        return getInstance(baseUrl.toHttpUrl(), timeOut)
    }

    fun getInstance(
        baseUrl: HttpUrl,
        timeOut: Long,
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(provideJson().asConverterFactory("application/json".toMediaType()))
            .client(provideOkhttpClient(5000))
            .build()

    private fun provideOkhttpClient(timeOut: Long): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(timeOut, TimeUnit.MILLISECONDS)
            .readTimeout(timeOut, TimeUnit.MILLISECONDS)
            .writeTimeout(timeOut, TimeUnit.MILLISECONDS)
            .apply {
                addInterceptor(provideInterceptor())
            }
            .build()
    }

    private fun provideJson(): Json {
        return Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }
    }

    private fun provideInterceptor(): Interceptor {
        return HttpLoggingInterceptor().also {
            it.level = HttpLoggingInterceptor.Level.BASIC
        }
    }

}
