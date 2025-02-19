package com.saika.composelearning.scroll

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScrollableStateLearning() {

    //HorizontalScrollingWithoutLazy()

    //VerticalScrollingWithoutLazy()

    //HorizontalScrolling()

    //VerticalScrolling()

    //LazyHorizontalStaggeredScrolling()

    LazyVerticalStaggeredScrolling()
}

@Composable
fun LazyVerticalStaggeredScrolling() {

    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(8)) {
        items(100) {
            Text(text = "#$it",
                fontSize = 16.sp,
                modifier = Modifier.padding(all = 16.dp)
            )
        }
    }
}

@Composable
fun LazyHorizontalStaggeredScrolling() {

    LazyHorizontalStaggeredGrid(rows = StaggeredGridCells.Fixed(4)) {
        items(100) {
            Text(text = "Item #$it",
                fontSize = 16.sp,
                modifier = Modifier.padding(all = 16.dp)
            )
        }
    }
}

@Composable
fun HorizontalScrolling() {
    val state = rememberLazyListState()
    val scope = rememberCoroutineScope()

    LazyRow(
        modifier = Modifier.fillMaxSize(),
        state,
        contentPadding = PaddingValues(50.dp),
        reverseLayout = false
    ) {
        items(100) {
            Text(text = "Item #$it",
                fontSize = 16.sp,
                modifier = Modifier.padding(all = 16.dp)
            )
        }
    }
}

@Composable
fun VerticalScrolling() {
    val state = rememberLazyListState()
    val scope = rememberCoroutineScope()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        state,
        contentPadding = PaddingValues(150.dp),
        reverseLayout = true
    ) {
        items(100) {
            Text(text = "Item #$it",
                fontSize = 16.sp,
                modifier = Modifier.padding(all = 16.dp)
            )
        }
    }
}


@Composable
fun HorizontalScrollingWithoutLazy() {
    val state = rememberScrollState()

    Row(modifier = Modifier
        .horizontalScroll(
            state = state
        )) {
        (0..100).forEach {
            Text(text = "Item #$it",
                fontSize = 16.sp,
                modifier = Modifier.padding(all = 16.dp)
            )
        }
    }
}

@Composable
fun VerticalScrollingWithoutLazy() {
    val state = rememberScrollState()

    Column(modifier = Modifier
        .verticalScroll(
            state = state
        )) {
        (0..100).forEach {
            Text(text = "Item #$it",
                fontSize = 16.sp,
                modifier = Modifier.padding(all = 16.dp)
                )
        }
    }
}