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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.Route
import com.surivalcoding.composerecipeapp.presentation.main_screen.MainScreen
import com.surivalcoding.composerecipeapp.presentation.main_screen.MainScreenState
import com.surivalcoding.composerecipeapp.presentation.saved_recipe_screen.SavedRecipeState
import com.surivalcoding.composerecipeapp.presentation.saved_recipe_screen.SavedRecipesScreen
import com.surivalcoding.composerecipeapp.ui.AppColors
import kotlinx.serialization.Serializable


@Composable
fun BottomNavigationScreen(
    savedRecipeState: SavedRecipeState = SavedRecipeState(),
    mainScreenState: MainScreenState = MainScreenState(),
    onBookmarkClick: (Int) -> Unit = {},
    onFocusedChange: (Int) -> Unit = {},
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController() // NavigationRoot의 NavController를 전달받음
) {
    val bottomNavController = rememberNavController()

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
                val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
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
                    selected = currentDestination?.hierarchy?.any { it.hasRoute(BottomRoute.Main::class) } == true,
                    onClick = {
                        bottomNavController.navigate(BottomRoute.Main) {
                            popUpTo<BottomRoute.Main> {
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
                    selected = currentDestination?.hierarchy?.any { it.hasRoute(BottomRoute.Bookmark::class) } == true,
                    onClick = {
                        bottomNavController.navigate(BottomRoute.Bookmark) {
                            popUpTo<BottomRoute.Main> {
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
                    selected = currentDestination?.hierarchy?.any { it.hasRoute(BottomRoute.Third::class) } == true,
                    onClick = {
                        bottomNavController.navigate(BottomRoute.Third) {
                            popUpTo<BottomRoute.Main> {
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
                    selected = currentDestination?.hierarchy?.any { it.hasRoute(BottomRoute.Fourth::class) } == true,
                    onClick = {
                        bottomNavController.navigate(BottomRoute.Fourth) {
                            popUpTo<BottomRoute.Main> {
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
            navController = bottomNavController,
            modifier = modifier.padding(it),
            startDestination = BottomRoute.Main,
        ) {
            composable<BottomRoute.Main> {
                MainScreen(
                    state = mainScreenState,
                    onSearchFieldClick = {
                        navHostController.navigate(Route.SearchRecipe) {
                            popUpTo(Route.BottomNav) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    },
                )
            }
            composable<BottomRoute.Bookmark> {
                SavedRecipesScreen(Modifier, savedRecipeState, onBookmarkClick)
            }
            composable<BottomRoute.Third> {
                ThirdScreen()
            }
            composable<BottomRoute.Fourth> {
                FourthScreen()
            }
        }
    }
}

sealed interface BottomRoute {
    @Serializable
    data object Main : BottomRoute

    @Serializable
    data object Bookmark : BottomRoute

    @Serializable
    data object Third : BottomRoute

    @Serializable
    data object Fourth : BottomRoute
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