package com.isgandroid.project.controllers

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.isgandroid.project.models.Screen
import com.isgandroid.project.views.theme.ui.AccountScreen
import com.isgandroid.project.views.theme.ui.DetailScreen
import com.isgandroid.project.views.theme.ui.HomeScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                })
        ) {
            DetailScreen(navController)
        }
        composable(
            route = Screen.Account.route
        ) {
            AccountScreen(navController)
        }
    }


}