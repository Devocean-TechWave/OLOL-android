package com.project.olol.presentation.ui.component

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.annotation.DrawableRes
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
    NavigationBar {
        val items = listOf(
            BottomNavItem.Mission,
            BottomNavItem.Friends,
            BottomNavItem.Test,
            BottomNavItem.My
        )
        items.forEach { item ->
            val icon: Painter = painterResource(id = if (selectedTab == item) item.iconSelected else item.iconUnselected)
            NavigationBarItem(
                icon = { Icon(painter = icon, contentDescription = item.title) },
                label = { Text(text = item.title) },
                selected = selectedTab == item,
                onClick = { onTabSelected(item) }
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
