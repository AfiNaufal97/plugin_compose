package com.plugin.coil

import android.os.Bundle
import android.util.Log

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import coil.compose.*
import coil.request.ImageRequest
import coil.size.Size
import coil.size.Size.Companion.ORIGINAL
import com.plugin.coil.ui.theme.CoilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoilTheme {
                Surface() {
                    GetWithCoil()
                }
            }
        }
    }
}


@Composable
fun GetWithCoil() {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://res.cloudinary.com/dycpjvu2b/image/upload/v1658505820/Screenshot_20220722-225855_r4vdrl.png")
            .size(coil.size.Size.ORIGINAL) // Set the target size to load the image at.
            .build()
    )
    if (painter.state is AsyncImagePainter.State.Error) {
        androidx.compose.material.Text(text = "Error")
    }

    if (painter.state is AsyncImagePainter.State.Loading) {
        CircularProgressIndicator()
    }

   if(painter.state is AsyncImagePainter.State.Success){
       Image(
           painter = painter,
           contentDescription = "Image"
       )
   }




}