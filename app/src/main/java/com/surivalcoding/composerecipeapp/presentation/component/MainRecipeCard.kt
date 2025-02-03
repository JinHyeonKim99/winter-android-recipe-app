package com.surivalcoding.composerecipeapp.presentation.component

import android.graphics.Color.BLUE
import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun MainRecipeCard(
    modifier: Modifier = Modifier,
    recipe: Recipe,
) {
    Box(
        modifier = modifier
            .size(width = 150.dp, height = 231.dp)
            .aspectRatio(150 / 231f)
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.TopCenter
    ) {
        // 상단 오른쪽 StarRate 아이콘
        MainScreenStarRateIcon(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 30.dp)
                .zIndex(1f)
        )

        // 카드 콘텐츠
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // 원형 이미지
            AsyncImage(
                modifier = Modifier
                    .size(110.dp)
                    .aspectRatio(1f)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
                model = if (LocalInspectionMode.current) {
                    ColorDrawable(BLUE)
                } else {
                    recipe.thumbnailUrl
                },
                contentDescription = recipe.title,
                placeholder = painterResource(R.drawable.ic_launcher_foreground)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 11.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = recipe.title,
                    style = AppTextStyles.smallTextBold.copy(
                        color = AppColors.gray1
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .size(130.dp, 42.dp)
                        .aspectRatio(130 / 42f)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 19.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                ) {
                    Text(
                        text = "Time",
                        style = AppTextStyles.smallerTextRegular.copy(
                            color = AppColors.gray3
                        ),
                        modifier = Modifier
                            .size(27.dp, 17.dp)
                            .aspectRatio(27 / 17f)
                    )

                    Text(
                        text = "${recipe.cookingDuration.substring(0, 2)} Mins",
                        style = AppTextStyles.smallerTextBold.copy(
                            color = AppColors.gray1
                        )
                    )
                }
            }
        }

        // 카드 배경
        Card(
            modifier = Modifier
                .size(150.dp, 176.dp)
                .aspectRatio(150 / 176f)
                .align(Alignment.BottomCenter)
                .zIndex(-1f),
        ) {
            // 추가적인 Card 내용
        }

        // 오른쪽 아래 Bookmark 아이콘
        BookmarkIcon(
            modifier = Modifier
                .align(Alignment.BottomEnd) // 오른쪽 아래 정렬
                .padding(end = 10.dp, bottom = 10.dp) // 여백 추가
                .zIndex(2f), // 가장 위에 표시
            recipeId = recipe.id, // recipe의 id를 전달
            onBookmarkClick = { id ->
                println("Bookmark clicked for recipe id: $id")
            }
        )
    }
}



@Preview()
@Composable
private fun MainRecipeCardPreview() {
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

    MainRecipeCard(
        recipe = recipe1
    )
}