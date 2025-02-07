package com.surivalcoding.composerecipeapp.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.surivalcoding.composerecipeapp.presentation.bottomscreen.BottomNavigationScreen
import com.surivalcoding.composerecipeapp.presentation.main_screen.MainScreenState
import com.surivalcoding.composerecipeapp.presentation.saved_recipe_screen.SavedRecipeState
import com.surivalcoding.composerecipeapp.presentation.search_recipes_screen.SearchRecipesState
import com.surivalcoding.composerecipeapp.presentation.search_recipes_screen.SearchRecipesScreen
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
}

@Composable
fun NavigationRoot(
    navHostController: NavHostController,
    mainScreenState: MainScreenState = MainScreenState(),
    savedRecipeState: SavedRecipeState = SavedRecipeState(),
    onBookmarkClick: (Int) -> Unit = {},
) {
    NavHost(
        navController = navHostController,
        startDestination = AuthGraph,
    ) {
        authGraph(
            navHostController,
            mainScreenState,
            savedRecipeState,
        )
    }
}

private fun NavGraphBuilder.authGraph(
    navHostController: NavHostController,
    mainScreenState: MainScreenState = MainScreenState(),
    savedRecipeState: SavedRecipeState = SavedRecipeState(),
    onBookmarkClick: (Int) -> Unit = {},
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
                mainScreenState = mainScreenState,
                savedRecipeState = savedRecipeState,
                onBookmarkClick = onBookmarkClick
            )
        }
        composable<Route.SearchRecipe> {
            SearchRecipesScreenRoot()
        }
    }
}