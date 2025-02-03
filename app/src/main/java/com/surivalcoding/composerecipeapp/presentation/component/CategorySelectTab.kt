package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.domain.model.Category
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun CategorySelectTab(
    modifier: Modifier = Modifier,
    categories: List<Category>,  // 카테고리를 Enum 리스트로 받음
    onCategorySelected: (Category) -> Unit = {},// 선택한 카테고리를 반환
) {
    var selectedCategory by remember { mutableStateOf(categories.first()) }
    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(scrollState),
        verticalAlignment = Alignment.CenterVertically
    ) {
        categories.forEach { category ->
            val isSelected = category == selectedCategory

            // 탭 크기 설정: 'All'은 54.dp x 31.dp, 나머지는 76.dp x 31.dp
            val tabWidth = if (category == Category.ALL) 54.dp else 76.dp

            Text(
                text = category.displayName, // Enum의 displayName 사용
                style = AppTextStyles.smallerTextBold,
                color = if (isSelected) AppColors.white else AppColors.primary80,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding()
                    .width(tabWidth) // 폭 설정
                    .height(31.dp) // 높이 설정
                    .background(
                        color = if (isSelected) AppColors.primary100 else Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .clickable {
                        selectedCategory = category
                        onCategorySelected(category) // 선택된 카테고리를 콜백으로 전달
                    }
                    .padding(horizontal = 4.dp, vertical = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CategorySelectTabPreview() {
    CategorySelectTab(
        categories = Category.entries,
        onCategorySelected = {}
    )
}