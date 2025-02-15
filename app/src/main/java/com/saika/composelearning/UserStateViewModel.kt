package com.saika.composelearning

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class UserStateViewModel: ViewModel() {

    val state = mutableStateOf(UserState())

    fun updateText(name: String) {

        state.value = state.value.copy(text = name)

    }

    fun updateNamesList() {
        val currentList = state.value.names
        currentList.add(state.value.text)
        state.value = state.value.copy(text = state.value.text)
    }

}