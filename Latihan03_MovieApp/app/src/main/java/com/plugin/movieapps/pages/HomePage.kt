package com.plugin.movieapps.pages
import android.content.res.Resources
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.plugin.movieapps.R
import com.plugin.movieapps.model.Movie
import com.plugin.movieapps.model.listMoview
import com.plugin.movieapps.navigator.ScreenPages


@Composable
fun HomePage(navController: NavController){
    Scaffold(
        
        topBar = {
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.Magenta),) {
            Text(text = stringResource(id = R.string.app_name), modifier = Modifier.padding(10.dp))
        }
    }) {
        ListComponent(listMoview(), navController)
    }
}

@Composable
fun ListComponent(listData:List<Movie>, navController: NavController){
    Column() {
        LazyColumn{
            items(count = listData.size){value ->
                CardComponent(movie = listData[value]){
                    valueData -> navController.navigate(route = ScreenPages.DetailPage.name+ "/${valueData.id}")
                }
            }
        }
    }
}

@Composable
fun CardComponent(movie: Movie, click:(Movie)->Unit){
    var isTrue = remember{
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            click(movie)
        }
        .padding(10.dp), shape = RoundedCornerShape(10.dp), elevation = 5.dp) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
           Card(
               modifier = Modifier
                   .width(100.dp)
                   .height(100.dp)
                   .padding(10.dp),
               shape = CircleShape) {
               Image(

                   painter = rememberAsyncImagePainter(model = movie.images[0]), contentDescription = "", modifier = Modifier
                       .fillMaxSize()
                       .animateContentSize()
                       .clip(CircleShape)

               )

           }
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
}

