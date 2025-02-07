package com.surivalcoding.composerecipeapp.presentation.search_recipes_screen.filter_search_bottom_sheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.presentation.component.FilterButton
import com.surivalcoding.composerecipeapp.presentation.component.SmallButton
import com.surivalcoding.composerecipeapp.presentation.search_recipes_screen.SearchRecipesAction
import com.surivalcoding.composerecipeapp.presentation.search_recipes_screen.SearchRecipesState
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterBottomSheet(
    modifier: Modifier = Modifier,
    state: SearchRecipesState,
    onAction: (SearchRecipesAction) -> Unit = {},
) {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
    )
    FilterButton(
        modifier = modifier,
        onClick = { onAction(SearchRecipesAction.OnClickFilterIconButton) }
    )

    if (state.showBottomSheet) {
        ModalBottomSheet(
            modifier = Modifier.fillMaxHeight(484 / 812f),
            sheetState = sheetState,
            onDismissRequest = { onAction(SearchRecipesAction.OnClickFilterButton) }
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                Text(
                    text = "Filter Search",
                    style = AppTextStyles.smallTextBold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                TimeFilterTabs(
                    text = "Time",
                    filterTabList = state.timeFilterList,
                    timeTab = state.selectedTimeTab,
                    onAction = onAction,
                )

                RateFilterTabs(
                    text = "Rate",
                    filterTabList = state.rateFilterList,
                    rateTab = state.selectedRateTab,
                    isSelected = state.isRateSelected,
                    onAction = onAction,
                )

                CategoryFilterTabs(
                    text = "Category",
                    modifier = Modifier.padding(end = 40.dp),
                    filterTabList = state.categoryFilterList,
                    categoryTab = state.selectedCategoryTab,
                    onAction = onAction,
                )

                SmallButton(
                    text = "Filter",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 10.dp),
                    onClick = {
                        onAction(SearchRecipesAction.OnClickFilterButton)
                    }
                )
            }

//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(30.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.spacedBy(10.dp)
//            ) {
//                searchRecipeState.filterTypeList.forEach { filterType ->
//                    val isSelected = filterType == selectedFilterType
//
//                    // 텍스트의 너비를 측정하기 위한 상태
//                    var textWidth by remember { mutableStateOf(0) }
//
//                    Text(
//                        text = filterType.displayName, // Enum의 displayName 사용
//                        style = AppTextStyles.smallerTextRegular,
//                        color = if (isSelected) AppColors.white else AppColors.primary80,
//                        textAlign = TextAlign.Center,
//                        onTextLayout = { textLayoutResult ->
//                            // 텍스트의 너비를 측정하여 상태 업데이트
//                            textWidth = textLayoutResult.size.width
//                        },
//                        modifier = Modifier
//                            .height(27.dp) // 높이 설정
//                            .background(
//                                color = if (isSelected) AppColors.primary100 else Color.Transparent,
//                                shape = RoundedCornerShape(10.dp)
//                            )
//                            .clickable {
//                                selectedFilterType = filterType
//                                onFilterTabSelected(filterType) // 선택된 카테고리를 콜백으로 전달
//                            }
//                            .padding(horizontal = 10.dp, vertical = 5.dp)
//                    )
//                }
//            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun FilterBottomSheetPreview() {
//    Box(
//        modifier = Modifier
//            .fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        FilterBottomSheet(
//
//        )
//    }
//}