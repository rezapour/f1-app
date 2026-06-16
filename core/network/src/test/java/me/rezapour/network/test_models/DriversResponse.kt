package me.rezapour.network.test_models

import me.rezapour.network.model.DriverResponse
import me.rezapour.network.model.DriverTableDto
import me.rezapour.network.model.DriverDto
import me.rezapour.network.model.MRDataDto

val expectedDriverListFromJson = DriverResponse(
    mRData = MRDataDto(
        xmlns = "",
        series = "f1",
        url = "https://api.jolpi.ca/ergast/f1/drivers/",
        limit = "2",
        offset = "0",
        total = "864",
        driverTable = DriverTableDto(
            drivers = arrayListOf(
                DriverDto(
                    driverId = "abate",
                    url = "http://en.wikipedia.org/wiki/Carlo_Mario_Abate",
                    givenName = "Carlo",
                    familyName = "Abate",
                    dateOfBirth = "1932-07-10",
                    nationality = "Italian"
                ),
                DriverDto(
                    driverId = "abecassis",
                    url = "http://en.wikipedia.org/wiki/George_Abecassis",
                    givenName = "George",
                    familyName = "Abecassis",
                    dateOfBirth = "1913-03-21",
                    nationality = "British"
                )
            )
        )
    )
)