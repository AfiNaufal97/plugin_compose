package com.plugin.movieapps.navigator

enum class ScreenPages {
    HomePage,
    DetailPage;
    companion object{
        fun navigate(route:String?):ScreenPages{
            return when(route?.substringBefore("/")){
                HomePage.name -> HomePage
                DetailPage.name ->DetailPage
                null -> HomePage
                else -> throw IllegalArgumentException("$route not found")
            }
        }
    }
}