package com.saika.composelearning.animations

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.saika.composelearning.R
import kotlin.random.Random

@Composable
fun AnimationLearning() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        //AnimationOne()

        //AnimationTwo()

        //AnimationThree()

        //AnimationFour()




    }
}

@Composable
private fun AnimationFour() {
    var scale by remember {
        mutableFloatStateOf(1f)
    }

    var color by remember {
        mutableStateOf(Color.Red)
    }

    val animateScale by animateFloatAsState(targetValue = scale, label = "")
    val animateColor by animateColorAsState(targetValue = color, label = "")

    Box(modifier = Modifier
        .size(15.dp)
        .scale(animateScale)
        .clip(CircleShape)
        .background(animateColor)
        .clickable {
            scale += 0.1f
            color = Color(
                red = Random.nextInt(255),
                green = Random.nextInt(255),
                blue = Random.nextInt(255)
            )
        }
    ) {

    }
}

@Composable
private fun AnimationThree() {
    var count by remember {
        mutableIntStateOf(0)
    }

    Button(onClick = { count++ }) {
        Text(text = "Add")
    }

    AnimatedContent(targetState = count, label = "", transitionSpec = {
        fadeIn() togetherWith scaleOut()
    }) {
        Text(text = "Count is $it")
    }
}

@Composable
private fun AnimationTwo() {
    var isMaxLinesVisible by remember {
        mutableStateOf(false)
    }

    Text(
        text = stringResource(R.string.lbl_sample).repeat(2),
        modifier = Modifier
            .padding(5.dp)
            .background(Color.Blue)
            .clickable {
                isMaxLinesVisible = !isMaxLinesVisible
            }
            .animateContentSize(
                animationSpec = TweenSpec(
                    durationMillis = 100,
                    easing = LinearEasing
                )
            ),
        maxLines = if (isMaxLinesVisible) Int.MAX_VALUE else 2
    )
}

@Composable
private fun ColumnScope.AnimationOne() {
    var isContentVisible by remember {
        mutableStateOf(false)
    }

    Spacer(modifier = Modifier.height(100.dp))

    Button(
        onClick = { isContentVisible = !isContentVisible }
    ) {
        Text(text = stringResource(R.string.lbl_show_hide))
    }

    Spacer(modifier = Modifier.height(10.dp))

    AnimatedVisibility(
        visible = isContentVisible,
        enter = scaleIn(),
        exit = scaleOut()
    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color.Red)
        )
    }
}