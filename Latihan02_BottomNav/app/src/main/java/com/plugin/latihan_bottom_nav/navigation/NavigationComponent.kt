package com.plugin.latihan_bottom_nav.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plugin.latihan_bottom_nav.screen.Favorite
import com.plugin.latihan_bottom_nav.screen.Home
import com.plugin.latihan_bottom_nav.screen.Profile

@Composable
fun NavigationComponent(navController:NavHostController) {
    NavHost(navController = navController, startDestination =NavScreen.Home.name ){
        composable(NavScreen.Home.name){
            Home()
        }

        composable(NavScreen.Favorite.name){
            Favorite()
        }

        composable(NavScreen.Profile.name){
            Profile()
        }
    }
}