package me.rezapour.constructors.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import me.rezapour.constructors.compose.ConstructorsScreen
import me.rezapour.constructors.viewmodel.ConstructorsListViewModel

fun NavGraphBuilder.constructorsNavGraph(
    nav: NavController
) {

    composable(
        route = ConstructorsRoute.List.route
    ) {
        val viewModel = hiltViewModel<ConstructorsListViewModel>(it)
        val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

        ConstructorsScreen(uiState = uiState, onBackPressed = {nav.popBackStack()}) {
            viewModel.intent(it)
        }

    }

}