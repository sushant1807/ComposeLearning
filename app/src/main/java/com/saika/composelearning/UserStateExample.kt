package com.saika.composelearning

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun UserStateExample(viewModel: UserStateViewModel) {

    Column(modifier = Modifier.fillMaxSize()) {

        val state = viewModel.state.value

        //MyTextFieldWithState()

        // or

        //Display the added names in the list

        //For TextField
//        var textState by remember {
//            mutableStateOf("")
//        }

        //This is used to save data from configuration changes
        //rememberSaveable works only with mutableStateOf
//        var textState by rememberSaveable {
//            mutableStateOf("")
//        }
//
//        //Add names in to this list
//        val namesListSpace = remember {
//            mutableStateListOf<String>()
//        }

        //To display the list
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .weight(1f)
        ) {
            items(state.names.size){
                Text(text = state.names[it])
            }
        }

        MyTextFieldWithOutState(
            textValue = state.text,
            onValueChanged = {
                viewModel.updateText(it)
            },
            onAddClick = {
                viewModel.updateNamesList()
                viewModel.updateText("")
            }
        )

    }

}

@Composable
fun MyTextFieldWithState(){
    var textState by remember {
        mutableStateOf("")
    }

    TextField(
        value = textState,
        onValueChange = {
            textState = it
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun MyTextFieldWithOutState(
    textValue: String,
    onValueChanged: (String) -> Unit,
    onAddClick: () -> Unit
){
    TextField(
        value = textValue,
        onValueChange = {
            onValueChanged(it)
        },
        modifier = Modifier.fillMaxWidth(),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier.clickable { onAddClick() }
            )
        }
    )
}