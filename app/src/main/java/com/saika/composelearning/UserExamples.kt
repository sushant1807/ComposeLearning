package com.saika.composelearning

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.saika.composelearning.ui.theme.ComposeLearningTheme

@Composable
fun ModifierExamples() {

    Box(
        modifier = Modifier
            .width(100.dp)
            .height(200.dp)
            .background(Color.Red, shape = RectangleShape)
    ) {

    }

}

@Composable
fun MessageUseCase(name: String) {

    //Spacer(modifier =  Modifier.width(80.dp))

    Row(modifier = Modifier.fillMaxWidth()) {

        Box(
            modifier = Modifier
                .background(Color.Red)
                .weight(2f)
                .height(100.dp)
        )

        Spacer(modifier = Modifier.width(5.dp))

        Box(
            modifier = Modifier
                .background(Color.Red)
                .weight(2f)
                .height(100.dp)
        )
    }

//    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//        Box(modifier = Modifier
//            .width(150.dp)
//            .height(100.dp)
//            .clip(RoundedCornerShape(15.dp))
//            .background(Color.Red)
//            .clickable {
//                println("Clicked here")
//            },
//            contentAlignment = Alignment.Center
//        ) {
//            Text(text = name, color = Color.White)
//        }
//    }


//    Box(modifier = Modifier
//        .padding(horizontal = 10.dp, vertical = 25.dp)
//        .fillMaxWidth()
//        .fillMaxHeight(0.5f)
//        .background(Color.Green, shape = RectangleShape)
//        ) {
//    }

//    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
//        Box(modifier = Modifier
//            .size(100.dp)
//            .clip(CircleShape)
//            .border(width = 15.dp, color = Color.Black, shape = CircleShape)
//            .border(width = 10.dp, color = Color.Red, shape = CircleShape)
//            .background(Color.Green)
//
//        ){
//
//        }
//    }
}

@Composable
fun GreetingCard(name: String) {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.spacedBy(10.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = name, fontSize = 22.sp, color = Color.Red, fontStyle = FontStyle.Italic,
//            fontWeight = FontWeight.Bold
//        )
//
//        Button(onClick = { println("Clicked here ") }, content = {
//            Text(text = "Click here")
//        })
//
//        Icon(
//            painter = painterResource(id = R.drawable.ic_launcher_foreground),
//            contentDescription = null,
//            tint = Color.Red
//        )
//
//        Image(
//            painter = painterResource(id = R.drawable.ic_launcher_foreground),
//            contentDescription = null,
//        )
//
//        FloatingActionButton(onClick = { /*TODO*/ }) {
//
//            //Text(text = "Hello")
//            Icon(
//                painter = painterResource(id = R.drawable.ic_launcher_foreground),
//                contentDescription = null
//            )
//
//        }
//
//        ExtendedFloatingActionButton(text = {
//            Text(text = "Hello", color = Color.Red)
//
//        }, icon = {
//            Icon(
//                painter = painterResource(id = R.drawable.ic_launcher_foreground),
//                contentDescription = null
//            )
//        }, onClick = { /*TODO*/ }
//        )
//
//        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterStart) {
//            Text(text = "Click here", modifier = Modifier.align(Alignment.TopStart))
//            Text(text = "Click here", modifier = Modifier.align(Alignment.TopCenter))
//            Text(text = "Click here", modifier = Modifier.align(Alignment.TopEnd))
//            Text(text = "Click here", modifier = Modifier.align(Alignment.CenterStart))
//            Text(text = "Click here", modifier = Modifier.align(Alignment.Center))
//            Text(text = "Click here", modifier = Modifier.align(Alignment.CenterEnd))
//            Text(text = "Click here", modifier = Modifier.align(Alignment.BottomStart))
//            Text(text = "Click here", modifier = Modifier.align(Alignment.BottomCenter))
//            Text(text = "Click here", modifier = Modifier.align(Alignment.BottomEnd))
//        }

//        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceAround) {
//            Text(text = "Hello", color = Color.Red)
//            Text(text = "World", color = Color.Blue)
//        }

//        Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
//            Text(text = "Hello", color = Color.Red)
//            Text(text = "World", color = Color.Blue)
//
//        }
//    }
}