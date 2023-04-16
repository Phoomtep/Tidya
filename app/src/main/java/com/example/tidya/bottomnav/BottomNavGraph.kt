package com.example.tidya.bottomnav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tidya.presentation.HistoryScreen
import com.example.tidya.presentation.HomeScreen
import com.example.tidya.presentation.SearchScreen
import com.example.tidya.model.User
import com.example.tidya.presentation.AddScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    user: User
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ){
        composable(route = BottomBarScreen.Home.route)
        {
            HomeScreen(user = user, navController = navController)
        }
        composable(route = BottomBarScreen.Search.route)
        {
            SearchScreen()
        }
        composable(route = BottomBarScreen.History.route)
        {
            HistoryScreen(user = user)
        }
        composable(route = BottomBarScreen.Add.route){
            AddScreen(navController = navController)
        }
    }

}