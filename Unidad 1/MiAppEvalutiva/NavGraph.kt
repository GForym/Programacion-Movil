package com.gustavo.miappevaluativa

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.background
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.platform.LocalContext

@Composable
fun NavGraph(
    navController: NavHostController,
    sharedViewModel: SharedViewModel = viewModel(),
    habitViewModel: HabitViewModel = viewModel()
) {
    val backgroundColor by sharedViewModel.backgroundColor.observeAsState(Color.White)

    Box(modifier = Modifier.fillMaxSize().background(backgroundColor)) {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                HomeScreen(
                    navController = navController,
                    habitViewModel = habitViewModel,
                    sharedViewModel = sharedViewModel
                )
            }
            composable("details/{habitName}") { backStackEntry ->
                val habitName = backStackEntry.arguments?.getString("habitName") ?: ""
                DetailScreen(navController, habitName, habitViewModel)
            }
            composable("add_habit") { AddHabitScreen(navController, habitViewModel) }
            composable("settings") { SettingsScreen(navController, sharedViewModel) }
        }
    }
}
