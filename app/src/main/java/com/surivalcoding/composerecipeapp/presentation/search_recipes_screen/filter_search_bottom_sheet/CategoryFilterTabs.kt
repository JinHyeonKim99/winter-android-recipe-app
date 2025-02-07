package com.surivalcoding.composerecipeapp.presentation.search_recipes_screen.filter_search_bottom_sheet

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.data.filter.Category
import com.surivalcoding.composerecipeapp.data.filter.FilterType
import com.surivalcoding.composerecipeapp.presentation.search_recipes_screen.SearchRecipesAction
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CategoryFilterTabs(
    modifier: Modifier = Modifier,
    filterTabList: List<FilterType>,
    categoryTab: FilterType = Category.ALL,
    onAction: (SearchRecipesAction) -> Unit = {},
    text: String = "",
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = text,
            style = AppTextStyles.smallTextBold
        )
        FlowRow(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            filterTabList.forEach { filterTab ->
                // 텍스트의 너비를 측정하기 위한 상태
                var textWidth by remember { mutableStateOf(0) }

                Text(
                    text = filterTab.displayName, // Enum의 displayName 사용
                    style = AppTextStyles.smallerTextRegular,
                    color = if (categoryTab == filterTab) AppColors.white else AppColors.primary80,
                    textAlign = TextAlign.Center,
                    onTextLayout = { textLayoutResult ->
                        // 텍스트의 너비를 측정하여 상태 업데이트
                        textWidth = textLayoutResult.size.width
                    },
                    modifier = Modifier
                        .height(27.dp) // 높이 설정
                        .background(
                            color = if (categoryTab == filterTab) AppColors.primary100 else Color.Transparent,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .border(
                            width = 1.dp,
                            color = AppColors.primary80,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .clickable {
                            onAction(SearchRecipesAction.OnCategoryFilterTabSelected(filterTab)) // 선택된 카테고리를 콜백으로 전달
                        }
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                )
            }
        }
    }
}