package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.presentation.main_screen.MainAction
import com.surivalcoding.composerecipeapp.presentation.main_screen.MainScreenState

@Composable
fun MainRecipeCardScroll(
    modifier: Modifier = Modifier,
    state: MainScreenState = MainScreenState(),
    onAction: (MainAction) -> Unit = {},
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .height(231.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(key = { recipe -> recipe.id }, items = state.recipes) { recipe ->
            MainRecipeCard(
                recipe = recipe,
                state = state,
                onAction = onAction,
            )
        }
    }
}

@Preview
@Composable
private fun MainRecipeCardScrollPreview() {
    val recipe1 = Recipe(
        "Italian",
        1,
        "Traditional spare ribs baked",
        "https://www.foodnews.news/data/photos/20210728/art_16261398155074_8642d5.jpg",
        "Chef John",
        "20 min",
        4.0,
        "",
        emptyList(),
    )
    val recipes = listOf(recipe1, recipe1, recipe1, recipe1, recipe1)

    MainRecipeCardScroll(
        state = MainScreenState(recipes = recipes)
    )
}