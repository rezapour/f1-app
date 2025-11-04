package me.rezapour.drivers.navigation

sealed class DriverRoute(val route: String) {

    data object Graph : DriverRoute("driver_graph")
    data object List : DriverRoute("driver_list")
    data object Detail : DriverRoute("driver_detail/{driverId}") {
        fun create(driverId: String) = "driver_detail/$driverId"
    }
}