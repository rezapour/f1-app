package me.rezapour.data.repository

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import me.rezapour.common.dispatcher.CoroutineDispatcherProvider
import me.rezapour.common.dispatcher.impl.TestCoroutineDispatcher
import me.rezapour.data.mapper.DriverNetworkMapper
import me.rezapour.data.mapper.F1NetworkMapper
import me.rezapour.domain.error.DomainException
import me.rezapour.domain.models.DriverDomain
import me.rezapour.domain.repository.F1DataRepository
import me.rezapour.network.ApiProvider
import me.rezapour.network.NetworkException
import me.rezapour.network.model.DriverListNetworkEntity
import me.rezapour.network.model.DriverTableNetworkEntity
import me.rezapour.network.model.DriversNetworkEntity
import me.rezapour.network.model.MRDataNetworkEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class F1DataRepositoryImplTest {

    private lateinit var f1DataRepository: F1DataRepository
    private lateinit var apiProvider: ApiProvider
    private lateinit var testDispatcher: CoroutineDispatcherProvider
    private var dispatcher = StandardTestDispatcher()
    private lateinit var mapper: F1NetworkMapper

    @BeforeEach
    fun setup() {
        apiProvider = mockk()
        testDispatcher = TestCoroutineDispatcher(dispatcher)
        mapper = F1NetworkMapper(driverMapper = DriverNetworkMapper())

        f1DataRepository = F1DataRepositoryImpl(
            api = apiProvider,
            dispatcher = testDispatcher,
            mapper = mapper
        )

    }

    @Test
    fun `getDrivers should return list of drivers`() = runTest(dispatcher) {
        coEvery {
            apiProvider.getDrivers(
                any(),
                any()
            )
        } returns generateMockDriverListNetworkEntity()

        val result = f1DataRepository.getDrivers()

        assertEquals(expectedDriverDomains(), result)
    }

    @Test
    fun `getDrivers when received NetworkException NoInternet should Return Domain InternetIssue  `() =
        runTest(dispatcher) {
            coEvery { apiProvider.getDrivers(any(), any()) } throws NetworkException.NoInternet()

            assertThrows<DomainException.InternetIssue> {
                f1DataRepository.getDrivers()
            }
        }

    @Test
    fun `getDrivers when received NetworkException Unauthorised should Return Domain Unauthorised  `() =
        runTest(dispatcher) {
            coEvery { apiProvider.getDrivers(any(), any()) } throws NetworkException.Unauthorised()

            assertThrows<DomainException.Unauthorised> {
                f1DataRepository.getDrivers()
            }
        }

    @Test
    fun `getDrivers received a null body should return DomainException generalException`() =
        runTest(dispatcher) {
            coEvery { apiProvider.getDrivers(any(), any()).mRData } returns null

            assertThrows<DomainException.GeneralException> {
                f1DataRepository.getDrivers()
            }

        }

    @Test
    fun `getDrivers received a HttpException should return DomainException InternetIssue`() =
        runTest(dispatcher) {
            coEvery {
                apiProvider.getDrivers(
                    any(),
                    any()
                ).mRData
            } throws NetworkException.HttpError(403)

            assertThrows<DomainException.InternetIssue> {
                f1DataRepository.getDrivers()
            }
        }

    @Test
    fun `getDrivers received a Body is corrupted should return DomainException InternetIssue`() =
        runTest(dispatcher) {
            coEvery {
                apiProvider.getDrivers(
                    any(),
                    any()
                ).mRData
            } throws NetworkException.BodyIsCorrupted()

            assertThrows<DomainException.InternetIssue> {
                f1DataRepository.getDrivers()
            }
        }




    private fun generateMockDriverListNetworkEntity(): DriverListNetworkEntity {
        val drivers = listOf(
            DriversNetworkEntity(
                driverId = "hamilton",
                url = "http://ergast.com/api/f1/drivers/hamilton",
                givenName = "Lewis",
                familyName = "Hamilton",
                dateOfBirth = "1985-01-07",
                nationality = "British"
            ),
            DriversNetworkEntity(
                driverId = "max_verstappen",
                url = "http://ergast.com/api/f1/drivers/max_verstappen",
                givenName = "Max",
                familyName = "Verstappen",
                dateOfBirth = "1997-09-30",
                nationality = "Dutch"
            )
        )

        return DriverListNetworkEntity(
            mRData = MRDataNetworkEntity(
                xmlns = "http://ergast.com/mrd/1.5",
                series = "f1",
                url = "http://ergast.com/api/f1/drivers.json",
                limit = "30",
                offset = "0",
                total = "2",
                driverTable = DriverTableNetworkEntity(
                    drivers = ArrayList(drivers)
                )
            )
        )
    }

    private fun expectedDriverDomains(): List<DriverDomain> {
        return listOf(
            DriverDomain(
                driverId = "hamilton",
                url = "http://ergast.com/api/f1/drivers/hamilton",
                givenName = "Lewis",
                familyName = "Hamilton",
                dateOfBirth = "1985-01-07",
                nationality = "British"
            ),
            DriverDomain(
                driverId = "max_verstappen",
                url = "http://ergast.com/api/f1/drivers/max_verstappen",
                givenName = "Max",
                familyName = "Verstappen",
                dateOfBirth = "1997-09-30",
                nationality = "Dutch"
            )
        )
    }
}