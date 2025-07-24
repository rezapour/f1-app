package me.rezapour.network.test_models

import me.rezapour.network.model.DriverListNetworkEntity
import me.rezapour.network.model.DriverTableNetworkEntity
import me.rezapour.network.model.DriversNetworkEntity
import me.rezapour.network.model.MRDataNetworkEntity

val expectedDriverListFromJson = DriverListNetworkEntity(
    mRData = MRDataNetworkEntity(
        xmlns = "",
        series = "f1",
        url = "https://api.jolpi.ca/ergast/f1/drivers/",
        limit = "2",
        offset = "0",
        total = "864",
        driverTable = DriverTableNetworkEntity(
            drivers = arrayListOf(
                DriversNetworkEntity(
                    driverId = "abate",
                    url = "http://en.wikipedia.org/wiki/Carlo_Mario_Abate",
                    givenName = "Carlo",
                    familyName = "Abate",
                    dateOfBirth = "1932-07-10",
                    nationality = "Italian"
                ),
                DriversNetworkEntity(
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