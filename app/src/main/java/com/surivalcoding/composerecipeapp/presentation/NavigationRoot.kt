package com.surivalcoding.composerecipeapp.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.surivalcoding.composerecipeapp.presentation.bottomscreen.BottomNavigationScreen
import com.surivalcoding.composerecipeapp.presentation.saved_recipes_screen.SavedRecipesScreenRoot
import com.surivalcoding.composerecipeapp.presentation.search_recipes_screen.SearchRecipesScreenRoot
import com.surivalcoding.composerecipeapp.presentation.sign_in.SignInScreen
import com.surivalcoding.composerecipeapp.presentation.sign_up.SignUpScreen
import com.surivalcoding.composerecipeapp.presentation.splash_screen.SplashScreen
import kotlinx.serialization.Serializable

@Serializable
data object AuthGraph

sealed interface Route {
    @Serializable
    data object Splash : Route

    @Serializable
    data object SignIn : Route

    @Serializable
    data object SignUp : Route

    @Serializable
    data object BottomNav : Route

    @Serializable
    data object SearchRecipe : Route

    @Serializable
    data object SavedRecipe : Route

    @Serializable
    data object RecipeDetail : Route
}

@Composable
fun NavigationRoot() {
    val navHostController: NavHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        startDestination = AuthGraph,
    ) {
        authGraph(
            navHostController,
        )
    }
}

private fun NavGraphBuilder.authGraph(
    navHostController: NavHostController,
) {
    navigation<AuthGraph>(
        startDestination = Route.Splash
    ) {
        composable<Route.Splash> {
            SplashScreen(
                onClick = {
                    navHostController.navigate(Route.SignIn) {
                        popUpTo<Route.Splash> {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
            )
        }
        composable<Route.SignIn> {
            SignInScreen(
                onSignUpClick = {
                    navHostController.navigate(Route.SignUp) {
                        popUpTo<Route.SignIn> {
                            inclusive = true // Route.SignIn 화면도 제거
                        }
                        launchSingleTop = true
                    }
                },
                onSignInClick = {
                    navHostController.navigate(Route.BottomNav) {
                        popUpTo<Route.SignIn> {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable<Route.SignUp> {
            SignUpScreen(
                onSignInClick = {
                    navHostController.navigate(Route.SignIn) {
                        popUpTo<Route.SignUp> {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }
        composable<Route.BottomNav> {
            BottomNavigationScreen(
                navHostController = navHostController,
            )
        }
        composable<Route.SearchRecipe> {
            SearchRecipesScreenRoot()
        }
        composable<Route.SavedRecipe> {
            SavedRecipesScreenRoot()
        }
        composable<Route.RecipeDetail> {

        }
    }
}