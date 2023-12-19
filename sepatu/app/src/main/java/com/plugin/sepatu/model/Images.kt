package com.plugin.sepatu.model

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.plugin.sepatu.R

data class Images(
    val image: Int
)

fun listImage(): List<Images> {
    return listOf(
        Images(image = R.drawable.vans),
        Images(image = R.drawable.vans),
        Images(image = R.drawable.vans)
    )
}