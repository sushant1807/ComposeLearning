package com.saika.composelearning.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ScreenNavigationLearning(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "screen_a") {

        composable(
            route = "screen_a",
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(1000)
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(1000)
                )
            }
        ) {
            ScreenA(
                navigateToB = {
                    navController.navigate("screen_b")
                }
            )
        }

        composable(
            route = "screen_b",
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(1000)
                )
            },
           popExitTransition  = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(1000)
                )
            }
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
            route = "screen_c",
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(1000)
                )
            },
            popExitTransition  = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(1000)
                )
            }
        ) {
            ScreenC(
                navigateToB = {
                    navController.popBackStack()
                },
                navigateToA = {
                    //Two ways to navigate back to A
                    navController.navigate("screen_a") {
                        //This is for clearing the backstack
                        popUpTo(0)
                    }


                    //navController.popBackStack()
                    //navController.popBackStack()
                }
            )
        }
    }
}