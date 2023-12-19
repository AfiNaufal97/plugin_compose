package com.plugin.sepatu.widget

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.plugin.sepatu.model.Images
import com.plugin.sepatu.model.listImage
import com.plugin.sepatu.styles.MyColors
import kotlinx.coroutines.*

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalViewPagger() {
    val pager = rememberPagerState()
    val size = listImage().size
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        HorizontalPager(
            state = pager,
            count = size
        ) { index ->
            Image(
                painter = painterResource(id = listImage()[index].image),
                contentDescription = "Image"
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        HorizontalTabs(
            items = listImage(), pagerState = pager, scope = scope
        )
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalTabs(
    items: List<Images>,
    pagerState: PagerState,
    scope: CoroutineScope
) {
    val with = items.size * 30
    TabRow(
        modifier = Modifier.width(with.dp).padding(10.dp),
        contentColor = MyColors.Grey,
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                height = 10.dp,
                color = MyColors.Black,
                modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }
    ) {
        items.forEachIndexed { index, item ->
            Surface(
                color = MyColors.Grey,
                modifier = Modifier
                    .height(10.dp)
                    .clickable {
                        scope.launch {
                            pagerState.animateScrollToPage(page = index)
                        }
                    }) {

            }
        }
    }
}

