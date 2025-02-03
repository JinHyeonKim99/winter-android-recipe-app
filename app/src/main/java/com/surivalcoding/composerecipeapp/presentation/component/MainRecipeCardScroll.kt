package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.domain.model.Recipe

@Composable
fun MainRecipeCardScroll(
    modifier: Modifier = Modifier,
    recipes: List<Recipe>,
) {
    val scrollState = rememberScrollState()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(231.dp)
            .horizontalScroll(scrollState),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        recipes.forEach { recipe ->
            MainRecipeCard(
                recipe = recipe,
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
        emptyList(),
    )
    val recipes = listOf(recipe1, recipe1, recipe1, recipe1, recipe1)

    MainRecipeCardScroll(
        recipes = recipes
    )
}