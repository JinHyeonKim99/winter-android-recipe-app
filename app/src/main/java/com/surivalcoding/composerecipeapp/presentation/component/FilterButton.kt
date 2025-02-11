package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.AppColors

@Composable
fun FilterButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Icon(
        modifier = modifier
            .size(40.dp)
            .aspectRatio(1f)
            .background(
                color = AppColors.primary100,
                shape = RoundedCornerShape(10.dp)
            ).padding(10.dp)
            .clickable { onClick() },
        painter = painterResource(id = R.drawable.filter_icon),
        contentDescription = null,
        tint = AppColors.white,
    )
}