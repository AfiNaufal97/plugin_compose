package com.plugin.latihanslicing.screen.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ImageComp(id:Int, big:Boolean) {
        if(big){
            Image(
                modifier = Modifier.padding(10.dp),
                painter = painterResource(id = id),
                contentDescription = "Image"
            )
        }else{
            Image(
                painter = painterResource(id = id),
                contentDescription = "Image"
            )

        }
}