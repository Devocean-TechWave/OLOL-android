package com.project.olol.presentation.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import com.project.olol.R
import com.project.olol.presentation.ui.component.BottomNavItem
import com.project.olol.presentation.ui.component.NavigationBar
import com.project.olol.presentation.ui.home.HomeFragment
import com.project.olol.presentation.ui.my.MyFragment
import com.project.olol.presentation.ui.ranking.RankingFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 초기 화면으로 HomeFragment 표시
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }


        // ComposeView에 NavigationBar를 설정
        val composeView: ComposeView = findViewById(R.id.compose_view)
        composeView.setContent {
            val selectedTab = remember { mutableStateOf<BottomNavItem>(BottomNavItem.Mission) }

            NavigationBar(selectedTab.value) { selectedTab.value = it }

            // 탭에 따라 Fragment 변경
            when (selectedTab.value) {
                BottomNavItem.Mission -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, HomeFragment())
                    .commit()
                BottomNavItem.My -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, MyFragment())
                    .commit()
                BottomNavItem.Ranking -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, RankingFragment())
                    .commit()
            }
        }
    }
}

