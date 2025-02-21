package com.saika.composelearning.navigation.arguments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.app.Person

@Composable
fun Screen1(navigateTo2: (com.saika.composelearning.navigation.arguments.Person) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var text by remember {
            mutableStateOf("")
        }

        var age by remember {
            mutableStateOf("")
        }

        var id by remember {
            mutableStateOf("")
        }
        
        TextField(value = text, onValueChange = { text = it})
        
        Spacer(modifier = Modifier.height(30.dp))

        TextField(value = age, onValueChange = { age = it})

        Spacer(modifier = Modifier.height(30.dp))

        TextField(value = id, onValueChange = { id = it})

        Spacer(modifier = Modifier.height(30.dp))
        
        Button(onClick = {
            navigateTo2(
                Person(name = text, age = age.toInt(), id = id.toInt())) }) {
            Text(text = "Go To 2")
        }
    }
}