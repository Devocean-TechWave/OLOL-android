package com.project.olol.presentation.ui.component

import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import com.project.olol.R

sealed class BottomNavItem(
    var title: String,
    @DrawableRes var iconSelected: Int,
    @DrawableRes var iconUnselected: Int
) {
    object Mission : BottomNavItem("미션", R.drawable.ic_mission_selected, R.drawable.ic_mission_unselected)
    object Friends : BottomNavItem("친구", R.drawable.ic_friends_selected, R.drawable.ic_friends_unselected)
    object Test : BottomNavItem("테스트", R.drawable.ic_test_selected, R.drawable.ic_test_unselected)
    object My : BottomNavItem("마이", R.drawable.ic_my_selected, R.drawable.ic_my_unselected)
}

@Composable
fun NavigationBar(selectedTab: BottomNavItem, onTabSelected: (BottomNavItem) -> Unit) {
    NavigationBar(
        containerColor = Color.White, // NavigationBar 배경색 흰색으로 설정
        modifier = Modifier.height(80.dp) // NavigationBar 높이 설정
    ) {
        val items = listOf(
            BottomNavItem.Mission,
            BottomNavItem.Friends,
            BottomNavItem.Test,
            BottomNavItem.My
        )
        items.forEach { item ->
            val icon: Painter = painterResource(id = if (selectedTab == item) item.iconSelected else item.iconUnselected)
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = icon,
                        contentDescription = item.title,
                        modifier = Modifier.size(21.dp) // 아이콘 크기 조정
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 10.sp, // 폰트 사이즈 조정
                        fontWeight = if (selectedTab == item) FontWeight.Bold else FontWeight.Normal
                    )
                },
                selected = selectedTab == item,
                onClick = { onTabSelected(item) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black, // 선택된 아이콘 색
                    unselectedIconColor = Color.Gray, // 선택되지 않은 아이콘 색
                    selectedTextColor = Color.Black, // 선택된 텍스트 색
                    unselectedTextColor = Color.Gray, // 선택되지 않은 텍스트 색
                    indicatorColor = Color.Transparent // 선택된 항목의 인디케이터 색 투명
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationBarPreview() {
    val selectedTab = remember { mutableStateOf<BottomNavItem>(BottomNavItem.Mission) }
    NavigationBar(selectedTab.value) { selectedTab.value = it }
}
