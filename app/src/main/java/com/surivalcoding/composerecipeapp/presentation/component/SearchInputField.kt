package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.search_recipes_screen.SearchRecipesAction
import com.surivalcoding.composerecipeapp.presentation.search_recipes_screen.SearchRecipesState
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SearchInputField(
    modifier: Modifier,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
) {
    var isFocused by remember { mutableStateOf(false) } // 초점 상태만 내부적으로 관리

    BasicTextField(
        value = value, // 외부 상태 사용
        onValueChange = onValueChange, // 외부 상태를 업데이트
        textStyle = AppTextStyles.smallerTextRegular.copy(
            fontSize = 11.sp,
            lineHeight = 17.sp,
            color = AppColors.font
        ), // 입력 텍스트 색상 설정
        modifier = modifier
            .aspectRatio(255 / 40f)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                width = 1.3.dp,
                color = if (isFocused) AppColors.primary80 else AppColors.gray4,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 10.dp)
            .onFocusChanged {
                isFocused = it.isFocused // 초점 상태 변경
            },
        decorationBox = { innerTextField ->
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier.fillMaxSize()
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
                        // 외부 상태를 기반으로 PlaceHolder 처리
                        if (value.isBlank()) {
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
                        innerTextField() // 실제 입력 필드
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun SearchInputFieldPreview() {
    Box(
        modifier = Modifier.fillMaxWidth()
            .height(200.dp),
        contentAlignment = Alignment.Center,
    ) {
        SearchInputField(
            modifier = Modifier,
            placeholder = "Search recipe",
            value = "",
            onValueChange = { }
        )
    }
}