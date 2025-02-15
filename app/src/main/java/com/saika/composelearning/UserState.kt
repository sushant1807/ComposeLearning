package com.saika.composelearning

data class UserState(

    val text: String = "",
    val names: MutableList<String> = mutableListOf()
)
