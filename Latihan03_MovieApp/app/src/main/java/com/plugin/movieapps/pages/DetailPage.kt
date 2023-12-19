package com.plugin.movieapps.pages

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.plugin.movieapps.model.Movie
import com.plugin.movieapps.model.listMoview

@Composable
fun DetailPage(navController: NavController, argument: String?){
    val movie:Movie = listMoview().filter { movie -> movie.id == argument }.first()
    var isTrue = remember{
        mutableStateOf(false)
    }

    Scaffold(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        topBar = {
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.Magenta),) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        navController.popBackStack()
                    })
                Spacer(modifier = Modifier.width(20.dp))
                Text(text = "Home Page", modifier = Modifier.padding(10.dp))
            }
    }) {

        Column() {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                shape = RoundedCornerShape(10.dp),
                elevation = 5.dp
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(10.dp)) {
                    Image(
                        modifier = Modifier.size(100.dp),
                        painter = rememberAsyncImagePainter(model = movie.images[0]), contentDescription = "Images")

                    Spacer(modifier = Modifier.width(20.dp))
                    Column(verticalArrangement = Arrangement.Center) {
                        Text(text = movie.title, style = MaterialTheme.typography.h5)
                        Text(text = movie.year, style = MaterialTheme.typography.h6)

                        AnimatedVisibility(visible = isTrue.value) {
                            Column() {
                                Text(movie.actors, style = MaterialTheme.typography.h6)
                                Text(movie.genre, style = MaterialTheme.typography.h6)
                                Text(movie.director, style = MaterialTheme.typography.h6)
                            }
                        }
                        Icon(imageVector = if(isTrue.value) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown, contentDescription ="Arrow" , modifier = Modifier
                            .size(35.dp)
                            .clickable {
                                isTrue.value = !isTrue.value
                            })
                    }
                }

            }
            
            Spacer(modifier = Modifier.height(30.dp))
            
            LazyRow(){
                items(movie.images.size){
                    count ->
                    Card(modifier = Modifier
                        .width(200.dp).height(200.dp)
                        .padding(20.dp)
                      ) {
                        Image(

                            painter = rememberAsyncImagePainter(model = movie.images[count]), contentDescription = "Images")
                    }
                }
            }
        }

    }}