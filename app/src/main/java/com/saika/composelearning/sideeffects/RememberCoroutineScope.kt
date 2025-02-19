package com.saika.composelearning.sideeffects

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RememberCoroutineScope() {
    val names = remember {
        (0..100).map { "Name #$it"}
    }

    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // Notes:
                    // We can't use LaunchedEffect, in this case it's a composable function
                    // We can call composable function from another composable function
                    // Here we need a callback inside a onCLick method.
                    scope.launch {
                        scrollState.animateScrollTo(scrollState.maxValue)
                    }
                }
            )
            {
                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = null)
            }
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .verticalScroll(scrollState)
        ) {
            names.forEach { name ->
                Text(text = name, modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp))
            }
        }
    }
}