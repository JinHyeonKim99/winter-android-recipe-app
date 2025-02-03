package com.surivalcoding.composerecipeapp.presentation.bottomscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.mainscreen.MainScreen
import com.surivalcoding.composerecipeapp.presentation.saved_recipe_screen.SavedRecipeState
import com.surivalcoding.composerecipeapp.presentation.saved_recipe_screen.SavedRecipesScreen
import com.surivalcoding.composerecipeapp.ui.AppColors
import kotlinx.serialization.Serializable


@Composable
fun BottomNavigationScreen(
    savedRecipeState: SavedRecipeState = SavedRecipeState(),
    onBookmarkClick: (Int) -> Unit = {},
    onFocusedChange: (Int) -> Unit = {},
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar =
        {
            BottomNavigation(
                modifier = Modifier
                    .height(92.dp)
                    .padding(top = 12.dp, start = 40.dp, end = 40.dp, bottom = 58.dp),
                backgroundColor = Color.Transparent,
                elevation = 0.dp,
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.main_on_icon),
                            tint = AppColors.primary80,
                            modifier = Modifier.size(24.dp),
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(end = 55.dp),
                    selected = currentDestination?.hierarchy?.any { it.hasRoute(Route.Main::class) } == true,
                    onClick = {
                        navController.navigate(Route.Main) {
                            popUpTo<Route.Main> {
                                inclusive = true
                            }
                            restoreState = true
                        }
                    }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.bookmark_off),
                            tint = AppColors.primary80,
                            modifier = Modifier
                                .size(24.dp)
                                .aspectRatio(1f),
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(end = 55.dp),
                    selected = currentDestination?.hierarchy?.any { it.hasRoute(Route.Bookmark::class) } == true,
                    onClick = {
                        navController.navigate(Route.Bookmark) {
                            popUpTo<Route.Main> {
                                inclusive = true
                            }
                            restoreState = true
                        }
                    }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.notification_icon),
                            tint = AppColors.primary80,
                            modifier = Modifier
                                .size(24.dp)
                                .aspectRatio(1f),
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 55.dp),
                    selected = currentDestination?.hierarchy?.any { it.hasRoute(Route.Third::class) } == true,
                    onClick = {
                        navController.navigate(Route.Third) {
                            popUpTo<Route.Main> {
                                inclusive = true
                            }
                            restoreState = true
                        }
                    }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.profile_icon),
                            tint = AppColors.primary80,
                            modifier = Modifier
                                .size(24.dp)
                                .aspectRatio(1f),
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 55.dp),
                    selected = currentDestination?.hierarchy?.any { it.hasRoute(Route.Fourth::class) } == true,
                    onClick = {
                        navController.navigate(Route.Fourth) {
                            popUpTo<Route.Main> {
                                inclusive = true
                            }
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) {
        NavHost(
            navController = navController,
            modifier = modifier.padding(it),
            startDestination = Route.Main,
        ) {
            composable<Route.Main> {
                MainScreen()
            }
            composable<Route.Bookmark> {
                SavedRecipesScreen(Modifier,savedRecipeState, onBookmarkClick)
            }
            composable<Route.Third> {
                ThirdScreen()
            }
            composable<Route.Fourth> {
                FourthScreen()
            }
        }
    }
}

private sealed interface Route {
    @Serializable
    data object Main : Route

    @Serializable
    data object Bookmark : Route

    @Serializable
    data object Third : Route

    @Serializable
    data object Fourth : Route
}

@Composable
fun ThirdScreen(modifier: Modifier = Modifier) {
    // center text
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Third")
    }
}

@Composable
fun FourthScreen(modifier: Modifier = Modifier) {
    // center text
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Fourth")
    }
}

@Preview
@Composable
private fun BottomNavigationScreenPreview() {
    BottomNavigationScreen()
}