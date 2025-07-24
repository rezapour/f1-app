package me.rezapour.network.impl


import com.google.common.io.Resources
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import me.rezapour.network.ApiProvider
import me.rezapour.network.NetworkError
import me.rezapour.network.retrofit.ApiService
import me.rezapour.network.retrofit.client.RetrofitClient
import me.rezapour.network.test_models.expectedDriverListFromJson
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

import java.io.File
import java.io.InputStream

class ApiProviderRetrofitImplTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var apiProvider: ApiProvider

    private val testDispatcher = StandardTestDispatcher()


    @BeforeEach
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
        val retrofit = RetrofitClient.getInstance(mockWebServer.url("/"), 1000)
        val apiService = retrofit.create(ApiService::class.java)
        apiProvider = ApiProviderRetrofitImpl(apiService)
    }

    @AfterEach
    fun destroy() {
        mockWebServer.shutdown()
    }

    private fun responseMapper(fileName: String): String {
        val inputStream: InputStream = File(Resources.getResource(fileName).toURI()).inputStream()
        return inputStream.bufferedReader().use { it.readText() }
    }

    @Test
    fun getDrivers() = runTest(testDispatcher) {
        val response = MockResponse()
            .setResponseCode(200)
            .setBody(responseMapper("DriverListResponse.json"))
        mockWebServer.enqueue(response)

        val driverList = apiProvider.getDrivers(0, 0)

        assertEquals(expectedDriverListFromJson, driverList)


    }

    @Test
    fun `getDrivers respond bodyIsCorrupted Error`() = runTest(testDispatcher) {
        val response = MockResponse()
            .setResponseCode(200)
            .setBody("1")
        mockWebServer.enqueue(response)

        assertThrows<NetworkError.BodyIsCorrupted> {
            apiProvider.getDrivers(0, 0)
        }

    }

    @Test
    fun `getDrivers respond UnAuthorised Error`() = runTest(testDispatcher) {
        val response = MockResponse()
            .setResponseCode(401)
            .setBody("")

        mockWebServer.enqueue(response)

        assertThrows<NetworkError.Unauthorised> {
            apiProvider.getDrivers(0,0)
        }
    }

    @Test
    fun `getDrivers respond HttpError Error`() = runTest(testDispatcher) {
        val response = MockResponse()
            .setResponseCode(500)
            .setBody("")

        mockWebServer.enqueue(response)

        assertThrows<NetworkError.HttpError> {
            apiProvider.getDrivers(0,0)
        }
    }
}