package com.surivalcoding.composerecipeapp.presentation.component

import android.widget.RatingBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun NewRecipeItem(
    modifier: Modifier = Modifier,
    itemIndex: Int,
    recipe: Recipe
) {
    Box(
        modifier = modifier
            .width(251.dp)
            .aspectRatio(251f / 127f)
    ) {
        Box(
            modifier = Modifier
                .shadow(elevation = 5.dp, shape = RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(95.dp)
                .background(
                    color = AppColors.white,
                    shape = RoundedCornerShape(10.dp)
                )
                .align(Alignment.BottomCenter)
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier.align(
                    Alignment.TopStart
                ),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    modifier = Modifier.width(140.dp),
                    text = recipe.title,
                    style = AppTextStyles.mediumTextBold.copy(
                        color = AppColors.gray1,
                        fontSize = 14.sp
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }


            // 왼쪽 하단 프로필 이미지와 셰프 이름
            Row(
                modifier = Modifier.align(
                    Alignment.BottomStart
                ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                AsyncImage(
                    model = R.drawable.profile_default_icon,
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )

                Text(
                    text = "By ${recipe.chef}",
                    style = AppTextStyles.smallerTextRegular.copy(
                        fontSize = 11.sp,
                        color = AppColors.gray3
                    )
                )
            }

            // 오른쪽 하단 시계 이미지와 쿠킹 타임
            Row(
                modifier = Modifier
                    .align(Alignment.BottomEnd),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Image(
                    modifier = Modifier
                        .padding(vertical = 4.dp),
                    painter = painterResource(R.drawable.timer),
                    contentDescription = null
                )

                Text(
                    text = "${recipe.cookingDuration}s",
                    modifier = Modifier
                        .padding(vertical = 4.dp),
                    style = AppTextStyles.smallerTextRegular.copy(
                        fontSize = 11.sp,
                        color = AppColors.gray3
                    )
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 10.dp)
        ) {
            // 이미지 로드 기능
            AsyncImage(
                model = recipe.thumbnailUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(86.dp)
                    .clip(CircleShape)
                    .align(Alignment.TopEnd),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
        }


    }
}