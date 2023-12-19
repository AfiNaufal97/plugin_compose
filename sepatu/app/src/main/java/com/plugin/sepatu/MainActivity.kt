package com.plugin.sepatu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.plugin.sepatu.styles.FontStyles
import com.plugin.sepatu.styles.MyColors
import com.plugin.sepatu.ui.theme.SepatuTheme
import com.plugin.sepatu.widget.BoxSizeWidget
import com.plugin.sepatu.widget.CircleColorWidget
import com.plugin.sepatu.widget.HorizontalViewPagger
import com.plugin.sepatu.widget.TextWidget


// sepatu plugin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SepatuTheme {
                Home()
            }
        }
    }
}

@Composable
fun Home() {
    val scroll = rememberScrollState(
        initial = 0
    )
    val size = rememberSaveable {
        mutableStateOf(7)
    }

    val price = rememberSaveable {
        mutableStateOf(97)
    }

    val color = remember {
        mutableStateOf(Color.Black)
    }

    val addCart = remember {
        mutableStateOf(false)
    }


    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(
                state = scroll
            )

    ) {

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            painter = painterResource(id = R.drawable.background),
            contentDescription = stringResource(id = R.string.background_app),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 27.dp)
        ) {
            HorizontalViewPagger()



            TextWidget(
                modifier = Modifier.padding(top = 92.dp),
                text = stringResource(id = R.string.vans),
                color = Color.Gray,
                weight = FontWeight.Medium,
                size = 17
            )

            TextWidget(
                modifier = Modifier,
                text = stringResource(id = R.string.old_skool),
                color = Color.Black,
                weight = FontWeight.SemiBold,
                size = 28
            )

            TextWidget(
                modifier = Modifier.padding(top = 8.dp),
                text = stringResource(id = R.string.desc),
                color = Color.Gray,
                weight = FontWeight.Medium,
                size = 15
            )

            TextWidget(
                modifier = Modifier.padding(top = 40.dp),
                text = stringResource(id = R.string.size),
                color = Color.Gray,
                weight = FontWeight.Medium,
                size = 15
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    BoxSizeWidget(
                        state = size,
                        text = 7,
                        modifier = Modifier,
                        color = Color.Black,
                        weight = FontWeight.Medium,
                        fontSize = 14,
                        size = {
                            size.value = it
                            price.value = 97
                        }
                    )

                    BoxSizeWidget(
                        state = size,
                        text = 8,
                        modifier = Modifier,
                        color = Color.Black,
                        weight = FontWeight.Medium,
                        fontSize = 14,
                        size = {
                            size.value = it
                            price.value = 98
                        }
                    )

                    BoxSizeWidget(
                        state = size,
                        text = 9,
                        modifier = Modifier,
                        color = Color.Black,
                        weight = FontWeight.Medium,
                        fontSize = 14,
                        size = {
                            size.value = it
                            price.value = 99
                        }
                    )

                }

                Text(
                    text = "\$ " + price.value.toString(), style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 28.sp,
                        color = Color.Black,
                        fontFamily = FontStyles.family
                    )
                )

            }


            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    TextWidget(
                        modifier = Modifier.padding(top = 40.dp),
                        text = stringResource(id = R.string.color),
                        color = Color.Gray,
                        weight = FontWeight.Medium,
                        size = 15
                    )
                    Row {
                        CircleColorWidget(state = color, color = Color.Black, clicColor = {
                            color.value = it
                        })
                        CircleColorWidget(state = color, color = Color.Red, clicColor = {
                            color.value = it
                        })
                    }

                }

                Button(modifier = Modifier
                    .width(170.dp)
                    .height(65.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                    onClick = {
                        addCart.value = true
                    }) {
                    TextWidget(
                        modifier = Modifier,
                        text = stringResource(id = R.string.add_cart),
                        color = Color.Gray,
                        weight = FontWeight.SemiBold,
                        size = 20
                    )
                }
            }


        }


        if (addCart.value) {
            AlertDialog(
                shape = RoundedCornerShape(30.dp),
                buttons = {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MyColors.Green),
                        onClick = {
                            addCart.value = false
                        }) {
                        Text(
                            "Close", style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = FontStyles.family,
                                color = MyColors.White


                            )
                        )
                    }
                },
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center) {
                        Text(
                            "Success Add To Cart",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.W600,
                                fontFamily = FontStyles.family
                            ),

                            )
                    }

                },
                text = {
                    val composition by rememberLottieComposition(
                        LottieCompositionSpec.RawRes(
                            R.raw.well
                        )
                    )
                    val progress by animateLottieCompositionAsState(composition = composition)
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        LottieAnimation(
                            modifier = Modifier
                                .width(150.dp)
                                .height(150.dp),
                            contentScale = ContentScale.FillBounds,
                            composition = composition, progress = { progress })
                    }

                },
                onDismissRequest = {
                    addCart.value = false
                })
        }


    }
}