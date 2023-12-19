package com.plugin.latihan_bottom_nav.navigation

import android.util.Log
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.plugin.latihan_bottom_nav.data.BottomData

@Composable
fun BottomNav(
    list:List<BottomData>,
    modifier: Modifier,
    background: Color,
    navController: NavController,
    elevation: Dp,
    click :(BottomData)->Unit
    ) {
    val bacStackEntry = navController.currentBackStackEntryAsState()
    Log.d("Value", "${bacStackEntry.value?.destination?.route}")
    BottomNavigation(
        modifier = modifier,
        elevation = elevation,
         backgroundColor = background
    ) {

        list.forEach {
            item ->
            val selected = item.route == bacStackEntry.value?.destination?.route
            BottomNavigationItem(
            selected = selected
                , onClick = {
            click(item)
        }, icon = {
                    if(selected){
                        Icon(imageVector = item.image, contentDescription ="", tint = Color.Green )
                    }else{
                        Icon(imageVector = item.image, contentDescription ="", tint = Color.White )
                    }
        }, label = {
                    if(selected){
                        Text(text = item.name, color = Color.Green)
                    }else{
                        Text(text = item.name, color = Color.White)
                    }
        },
                unselectedContentColor = Color.White,
                selectedContentColor = Color.Green)
        }
    }
}