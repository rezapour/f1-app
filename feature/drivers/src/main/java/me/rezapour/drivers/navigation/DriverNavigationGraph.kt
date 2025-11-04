package me.rezapour.drivers.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import me.rezapour.drivers.compse.DriverDetailScreen
import me.rezapour.drivers.compse.DriversScreen
import me.rezapour.drivers.viewmodel.DriverDetailViewModel
import me.rezapour.drivers.viewmodel.DriverListViewModel

fun NavGraphBuilder.driverNavGraph(nav: NavController) {

    navigation(
        route = DriverRoute.Graph.route,
        startDestination = DriverRoute.List.route
    ) {
        composable(route = DriverRoute.List.route) {
            val viewmodel = hiltViewModel<DriverListViewModel>()
            val uiState = viewmodel.uiState.collectAsStateWithLifecycle().value
            DriversScreen(
                uiState = uiState
            ) {
                nav.navigate(route = DriverRoute.Detail.create(it)) {
                    launchSingleTop = true       // avoid duplicate on reselect
                    restoreState = true          // bring back previous scroll state if saved
//                    popUpTo(DriverRoute.list) { inclusive = false }
                }
            }
        }

        composable(
            route = DriverRoute.Detail.route,
            arguments = listOf(navArgument("driverId") { type = NavType.StringType })
        ) {backStackEntry->
//            val id = it.arguments?.getString("driverId") ?: ""
//            val viewmodel:DriverDetailViewModel = hiltViewModel<DriverDetailViewModel>()
//            val viewmodel:DriverDetailViewModel = viewModel()
//            val viewmodel:DriverDetailViewModel = viewModel(backStackEntry)
            val viewmodel:DriverDetailViewModel = hiltViewModel(backStackEntry)

            val id = viewmodel.driverId
            backStackEntry.viewModelStore
            DriverDetailScreen(driverId = id) {
                nav.popBackStack()
            }
        }
    }
}