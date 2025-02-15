package com.saika.composelearning

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun UserText() {

    Box(modifier = Modifier.fillMaxSize().background(Color.Black), contentAlignment = Alignment.Center) {

//        Text(
//            text = stringResource(id = R.string.app_name),
////                .plus(" ")
////                .repeat(30),
//            //maxLines = 3,
//            //overflow = TextOverflow.Ellipsis
//
//            color = Color.Magenta,
//            fontSize = 32.sp,
//            textAlign = TextAlign.Center,
//            modifier = Modifier.fillMaxWidth()
//
//
//        )

        //Material design to display many colors in a text using BuildAnnotatedString

        val annotatedString = buildAnnotatedString {
            extractedText("Compose")
            append("\n\n")
            extractedMultiText(text = "Learning")
        }
        
        Text(text = annotatedString)


    }

}

@Composable
private fun AnnotatedString.Builder.extractedText(text: String) {
    withStyle(
        style = SpanStyle(
            brush = Brush.linearGradient(
                colors = listOf(
                    Color.Red,
                    Color.White
                )
            ),
            fontSize = 42.sp,
            fontWeight = FontWeight.Medium
        )
    ) {
        append(text)
    }
}

@Composable
private fun AnnotatedString.Builder.extractedMultiText(text: String) {
    withStyle(
        style = SpanStyle(
            brush = Brush.linearGradient(
                colors = listOf(
                    Color.Blue,
                    Color.White
                )
            ),
            fontSize = 42.sp,
            fontWeight = FontWeight.Medium
        )
    ) {
        append(text)
    }
}