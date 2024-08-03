package com.project.olol.presentation.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.project.olol.presentation.ui.component.BottomNavItem
import com.project.olol.presentation.ui.component.NavigationBar
import com.project.olol.presentation.ui.theme.OLOLTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OLOLTheme {
                val selectedTab = remember { mutableStateOf<BottomNavItem>(BottomNavItem.Mission) }

                Scaffold(
                    bottomBar = {
                        NavigationBar(selectedTab.value) { selectedTab.value = it }
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        when (selectedTab.value) {
                            BottomNavItem.Mission -> MissionScreen()
                            BottomNavItem.Friends -> FriendsScreen()
                            BottomNavItem.Test -> TestScreen()
                            BottomNavItem.My -> MyScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MissionScreen() {
    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "미션 화면")
    }
}

@Composable
fun FriendsScreen() {
    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "친구 화면")
    }
}

@Composable
fun TestScreen() {
    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "테스트 화면")
    }
}

@Composable
fun MyScreen() {
    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "마이 화면")
    }
}

// Previews
@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    OLOLTheme {
        val selectedTab = remember { mutableStateOf<BottomNavItem>(BottomNavItem.Mission) }
        Scaffold(
            bottomBar = {
                NavigationBar(selectedTab.value) { selectedTab.value = it }
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                when (selectedTab.value) {
                    BottomNavItem.Mission -> MissionScreen()
                    BottomNavItem.Friends -> FriendsScreen()
                    BottomNavItem.Test -> TestScreen()
                    BottomNavItem.My -> MyScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MissionScreenPreview() {
    OLOLTheme {
        MissionScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun FriendsScreenPreview() {
    OLOLTheme {
        FriendsScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun TestScreenPreview() {
    OLOLTheme {
        TestScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {
    OLOLTheme {
        MyScreen()
    }
}