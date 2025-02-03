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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun StarRateIcon(
    modifier: Modifier = Modifier,
    starRate: Double = 0.0,
) {
    Box(
        modifier = modifier
            .size(width = 37.dp, height = 16.dp)
            .aspectRatio(37 / 16f)
            .background(
                color = AppColors.secondary20,
                shape = RoundedCornerShape(size = 20.dp)
            )
            .padding(horizontal = 7.dp, vertical = 2.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Rate Star",
                tint = AppColors.rating,
                modifier = Modifier
                    .size(8.dp)
                    .aspectRatio(1f)
            )
            Text(
                text = "$starRate",
                style = AppTextStyles.smallerTextLabel,
                modifier = Modifier
                    .size(12.dp)
                    .aspectRatio(1f)
            )
        }
    }
}

@Preview
@Composable
private fun StarRateIconPreview() {
    StarRateIcon()
}