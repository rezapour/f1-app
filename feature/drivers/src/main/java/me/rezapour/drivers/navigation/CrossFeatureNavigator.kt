package me.rezapour.drivers.navigation

import androidx.navigation.NavController

fun NavController.navigateToDriverDetail(driverId: String) {
    navigate(DriverRoute.Detail.create(driverId))
}