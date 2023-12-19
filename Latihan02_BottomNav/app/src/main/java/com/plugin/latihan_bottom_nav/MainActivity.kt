package com.plugin.latihan_bottom_nav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.plugin.latihan_bottom_nav.data.BottomData
import com.plugin.latihan_bottom_nav.navigation.BottomNav
import com.plugin.latihan_bottom_nav.navigation.NavScreen
import com.plugin.latihan_bottom_nav.navigation.NavigationComponent
import com.plugin.latihan_bottom_nav.ui.theme.Latihan_bottom_navTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Latihan_bottom_navTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    Scaffold(

                        bottomBar = {
                            BottomNav(
                                list = listOf(
                                    BottomData(
                                        name = "Home",
                                        route = NavScreen.Home.name,
                                        image = Icons.Default.Home,
                                        badge = 0
                                    ),
                                    BottomData(
                                        name = "Favorite",
                                        route = NavScreen.Favorite.name,
                                        image = Icons.Default.Favorite, badge = 0
                                    ),
                                    BottomData(
                                        name = "Profile",
                                        route = NavScreen.Profile.name,
                                        image = Icons.Default.Person,
                                        badge = 0
                                    )
                                ), modifier =Modifier.fillMaxWidth(), background = Color.Gray, elevation =5.dp,
                                click = {
                                    navController.navigate(it.route)
                                },
                                navController = navController
                            )
                        }
                    ) {

                        NavigationComponent(navController)
                    }
                }
            }
        }
    }
}
