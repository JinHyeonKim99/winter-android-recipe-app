package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun MainScreenSearchInputField(
    modifier: Modifier,
    placeholder: String,
    onClick: () -> Unit = {},
) {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = modifier
            .aspectRatio(255 / 40f)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                width = 1.3.dp,
                color = AppColors.gray4,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 10.dp)
            .clickable {
                onClick()
            },
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(18.dp),
                painter = painterResource(id = R.drawable.search),
                contentDescription = null,
                tint = AppColors.gray4,
            )
            Box(
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterStart),
                    text = placeholder,
                    style = AppTextStyles.smallerTextRegular.copy(
                        fontSize = 11.sp,
                        lineHeight = 17.sp,
                        color = AppColors.gray4
                    ),
                )
            }
        }
    }
}