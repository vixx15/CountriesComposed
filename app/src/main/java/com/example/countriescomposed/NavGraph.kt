package com.example.countriescomposed

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import java.util.Locale

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModel: CountriesViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    NavHost(navController = navController, startDestination = Screens.MainScreen.route) {


        composable(route = Screens.MainScreen.route) {
            MainScreen(
                viewModel = viewModel,
                navController = navController
            )
        }

        composable(
            route = Screens.DetailScreen.route )
         {
            DetailsScreen(viewModel = viewModel)
        }
    }
}