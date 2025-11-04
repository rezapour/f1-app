package me.rezapour.f1app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import me.rezapour.constructors.navigation.constructorsNavGraph
import me.rezapour.designsystem.theme.F1AppTheme
import me.rezapour.drivers.navigation.DriverRoute
import me.rezapour.drivers.navigation.driverNavGraph

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            F1AppTheme {
                val nav = rememberNavController()

                NavHost(navController = nav, startDestination = DriverRoute.List.route) {

                    driverNavGraph(nav)
                    constructorsNavGraph(nav)

                }
            }
        }
    }
}

