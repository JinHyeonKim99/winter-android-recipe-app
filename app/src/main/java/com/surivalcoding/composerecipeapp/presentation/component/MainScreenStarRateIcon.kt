package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun MainScreenStarRateIcon(
    modifier: Modifier = Modifier,
    starRate: Double = 0.0,
) {
    Box(
        modifier = modifier
            .size(width = 45.dp, height = 23.dp)
            .aspectRatio(45 / 23f)
            .background(
                color = AppColors.secondary20,
                shape = RoundedCornerShape(size = 20.dp)
            )
            .padding(start = 7.dp, end = 7.dp, top = 3.dp, bottom = 3.dp),
    ) {
        Row(
            modifier = Modifier
                .size(31.dp, 17.dp)
                .align(Alignment.Center),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Rate Star",
                tint = AppColors.rating,
                modifier = Modifier
                    .size(10.dp)
                    .aspectRatio(1f)
            )
            Text(
                text = "$starRate",
                style = AppTextStyles.smallerTextRegular,
                modifier = Modifier
                    .size(17.dp)
                    .aspectRatio(1f)
            )
        }
    }
}