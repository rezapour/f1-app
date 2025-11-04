package me.rezapour.constructors.navigation

sealed class ConstructorsRoute(val route:String) {

    data object List: ConstructorsRoute(route = "constructors_list")

}