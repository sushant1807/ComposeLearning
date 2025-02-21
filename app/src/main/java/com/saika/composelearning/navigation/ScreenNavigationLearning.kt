package com.saika.composelearning.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ScreenNavigationLearning(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "screen_a") {

        composable(
            route = "screen_a"
        ) {

        }
        composable(
            route = "screen_a"
        ) {
            ScreenA(
                navigateToB = {
                    navController.navigate("screen_b")
                }
            )
        }

        composable(
            route = "screen_b"
        ) {
            ScreenB(
                navigateToC = {
                    navController.navigate("screen_c")
                },
                goBackToA = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = "screen_c"
        ) {
            ScreenC(
                navigateToB = {
                    navController.popBackStack()
                },
                navigateToA = {
                    navController.popBackStack()
                    navController.popBackStack()
                }
            )
        }
    }
}