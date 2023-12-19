package com.plugin.latihanslicing.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plugin.latihanslicing.screen.home.component.ImageComp
import com.plugin.latihanslicing.screen.home.component.TextComp
import com.plugin.latihanslicing.R
import com.plugin.latihanslicing.utils.MyColors


@Composable
fun Home() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                state = rememberScrollState()
            )
    ) {
        BoxWithConstraints() {
            Column {
                ImageComp(R.drawable.img_main, true)
                Spacer(modifier = Modifier.height(15.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp)
                ) {
                    TextComp(
                        text = stringResource(id = R.string.title_content),
                        color = MyColors.black,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Row {
                        Image(
                            modifier = Modifier
                                .width(26.dp)
                                .height(26.dp),
                            painter = painterResource(id = R.drawable.ic_logo),
                            contentDescription = "logo"
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        TextComp(
                            text = stringResource(id = R.string.name_org),
                            color = MyColors.black,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp
                        )
                    }
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(color = MyColors.grey, fontSize = 15.sp)) {
                                append(stringResource(id = R.string.description))
                            }
                            append(stringResource(id = R.string.more))

                        },
                        color = MyColors.black,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column() {
                            TextComp(
                                text = stringResource(id = R.string.donate),
                                color = MyColors.grey,
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Row {
                                androidx.compose.material.Surface(
                                    modifier = Modifier.size(30.dp),
                                    shape = CircleShape
                                ) {
                                    ImageComp(id = R.drawable.img_profile1, false)
                                }
                                androidx.compose.material.Surface(
                                    modifier = Modifier.size(30.dp),
                                    shape = CircleShape
                                ) {
                                    ImageComp(id = R.drawable.img_profile2, false)
                                }

                            }
                        }

                        Column() {
                            TextComp(
                                text = stringResource(id = R.string.total_money_title),
                                color = MyColors.grey,
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            TextComp(
                                text = stringResource(id = R.string.total_money),
                                color = MyColors.black,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 15.sp
                            )

                        }
                    }

                    Spacer(modifier = Modifier.height(25.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MyColors.pink)
                    ) {
                        TextComp(
                            text = stringResource(id = R.string.text_button),
                            color = MyColors.white,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(46.dp))
                }

            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp), horizontalArrangement = Arrangement.SpaceBetween) {
               Surface(modifier = Modifier.width(40.dp).height(40.dp), elevation = 1.dp, shape = CircleShape, color = MyColors.white.copy(
                   0.5f
               )) {

                   Icon(
                       modifier = Modifier.width(20.dp).height(20.dp).padding(10.dp),
                       painter = painterResource(R.drawable.ic_baseline_arrow_back_24), contentDescription = "Icon", tint = MyColors.white)
               }
                Surface(modifier = Modifier.width(40.dp).height(40.dp), elevation = 1.dp, shape = CircleShape, color = MyColors.white.copy(
                    0.5f
                )) {

                    Icon(
                        modifier = Modifier.width(20.dp).height(20.dp).padding(10.dp),
                        painter = painterResource(R.drawable.ic_baseline_bookmark_24), contentDescription = "Icon", tint = MyColors.white)
                }
            }
        }


    }

}



