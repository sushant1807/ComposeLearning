package com.saika.composelearning.navigation.arguments

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavigationWithArguments() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "screen_1") {
        composable(
            route = "screen_1"
        ) {
            Screen1(
                navigateTo2 = {
                    navController.currentBackStackEntry?.savedStateHandle?.set("person", it)
                    navController.navigate("screen_2")
                }
            )
        }

        composable(
            route = "screen_2",
        ) {
            navController.previousBackStackEntry?.savedStateHandle?.get<Person>("person")?.let {
                Screen2(it)
            }
        }
    }
}

@Composable
fun NavigateWithArgumentsUsingDataTypes(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "screen_1") {
        composable(
            route = "screen_1"
        ) {
            Screen1(
                navigateTo2 = {
                    navController.navigate("screen_2/$it")
                }
            )
        }

        composable(
            route = "screen_2/{text}",
            arguments = listOf(
                navArgument("text") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = "Unknown"
                }
            )
        ) {
            it.arguments?.getString("text")?.let {
                //If argument is a String/Int/Boolean etc
                //Screen2(it)
            }
        }
    }
}