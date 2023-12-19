package com.plugin.movieapps.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.plugin.movieapps.pages.DetailPage
import com.plugin.movieapps.pages.HomePage

@Composable
fun  ScreenNavigator() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenPages.HomePage.name){
            composable(ScreenPages.HomePage.name){
                HomePage(navController)
            }

            composable(ScreenPages.DetailPage.name+"/{key}", arguments = listOf(navArgument(name = "key"){
                NavType.StringType
            })){argumentsData ->
                DetailPage(navController, argumentsData.arguments?.getString("key")?:"")
            }
        }


}