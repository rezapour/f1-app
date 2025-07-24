package me.rezapour.network.retrofit.client

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    fun getInstance(
        baseUrl: String,
        timeOut: Long
    ): Retrofit {
        return getInstance(baseUrl.toHttpUrl(), timeOut)
    }

    fun getInstance(
        baseUrl: HttpUrl,
        timeOut: Long
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(provideGsonConverterFactory())
            .client(provideOkhttpClient(5000))
            .build()

    private fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(provideGsonBuilder())
    }

    private fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    private fun provideOkhttpClient(timeOut: Long): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(timeOut, TimeUnit.MILLISECONDS)
            .readTimeout(timeOut, TimeUnit.MILLISECONDS)
            .writeTimeout(timeOut, TimeUnit.MILLISECONDS)
            .addInterceptor(provideInterceptor())
            .build()
    }

    private fun provideInterceptor(): Interceptor {
        return HttpLoggingInterceptor().also {
            it.level = HttpLoggingInterceptor.Level.BASIC
        }
    }

}