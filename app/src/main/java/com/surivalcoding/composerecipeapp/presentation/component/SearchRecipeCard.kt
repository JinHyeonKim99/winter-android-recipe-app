package com.surivalcoding.composerecipeapp.presentation.component

import android.graphics.Color.BLUE
import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SearchRecipeCard(
    recipe: Recipe,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop,
            model = if (LocalInspectionMode.current) {
                ColorDrawable(BLUE)
            } else {
                recipe.thumbnailUrl
            },
            contentDescription = recipe.title,
            placeholder = painterResource(R.drawable.ic_launcher_foreground)
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,  // 위쪽은 투명 (밝게)
                            Color.Black.copy(alpha = 1f)  // 아래쪽은 어두운 색 (밝기 차이를 둔 그라데이션)
                        ),
                        startY = 0f,    // 위쪽부터 시작
                        endY = Float.POSITIVE_INFINITY // 아래쪽 끝까지
                    )
                )
        )

        Row(
            modifier = Modifier
                .align(Alignment.TopEnd) // 오른쪽 상단 정렬
                .width(37.dp)
                .height(16.dp)
                .offset(x = (-10).dp, y = 10.dp) // 모서리에서 10.dp 안쪽으로 이동
                .background(
                    color = AppColors.secondary20,
                    shape = RoundedCornerShape(size = 20.dp)
                ),
//                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically // 아이콘과 텍스트를 세로 중앙 정렬
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Rate Star",
                tint = AppColors.rating,
                modifier = Modifier
                    .aspectRatio(8 / 8f)
                    .weight(1f)
            )
            Text(
                text = recipe.starRate.toString(),
                style = AppTextStyles.smallerTextLabel,
                modifier = Modifier.size(12.dp)
                    .weight(1f)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column(
                modifier = Modifier
            ) {
                Text(
                    text = recipe.title,
                    style = AppTextStyles.smallerTextBold.copy(
                        color = AppColors.white,
                        fontSize = 11.sp,
                        lineHeight = 17.sp
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Visible,
                )
                Text(
                    text = "By ${recipe.chef}",
                    style = AppTextStyles.smallerTextLabel.copy(
                        fontSize = 8.sp,
                        lineHeight = 12.sp,
                        color = AppColors.gray4
                    )
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun SearchRecipeCardPreview() {
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

    Row(
        modifier = Modifier.size(300.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        SearchRecipeCard(recipe = recipe1)
        SearchRecipeCard(recipe = recipe1)
    }
}