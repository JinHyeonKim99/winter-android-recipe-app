package com.surivalcoding.composerecipeapp.presentation.mainscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.domain.model.Category
import com.surivalcoding.composerecipeapp.presentation.component.CategorySelectTab
import com.surivalcoding.composerecipeapp.presentation.component.FilterButton
import com.surivalcoding.composerecipeapp.presentation.component.MainRecipeCard
import com.surivalcoding.composerecipeapp.presentation.component.SearchInputField
import com.surivalcoding.composerecipeapp.presentation.search_recipes_screen.SearchRecipeState
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    state: SearchRecipeState = SearchRecipeState(),
    onValueChange: (String) -> Unit = {},
    waitSavedRecipes: () -> Unit = {},
    categories: List<Category> = Category.entries,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.white),
    ) {
        // TopBar에 Text와 SearchInput 배치
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp, start = 30.dp, end = 30.dp),
            verticalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Text(
                            text = "Hello Jega",
                            style = AppTextStyles.largeTextBold.copy(
                                color = AppColors.font
                            )
                        )
                        Text(
                            text = "What are you cooking today?",
                            style = AppTextStyles.smallerTextRegular.copy(
                                fontSize = 11.sp,
                                lineHeight = 17.sp,
                                color = AppColors.font
                            )
                        )
                    }

                    Image(
                        modifier = Modifier
                            .size(40.dp)
                            .aspectRatio(1f)
                            .background(
                                color = AppColors.secondary40,
                                shape = RoundedCornerShape(10.dp)
                            ),
                        painter = painterResource(id = R.drawable.profile_default_icon),
                        contentDescription = "Profile default icon",
                        contentScale = ContentScale.FillBounds
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                ) {
                    SearchInputField(
                        modifier = Modifier.weight(255f),
                        onValueChange = onValueChange,
                        placeholder = "Search recipe",
                        value = state.query,
                    )

                    FilterButton(
                        modifier = Modifier.weight(40f)
                    )
                }
            }

            CategorySelectTab(
                categories = categories,
            )


            MainRecipeCard(
                recipe = state.recipes
            )
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}