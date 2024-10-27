package com.project.olol.presentation.ui.mission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.olol.R
import androidx.viewpager2.widget.ViewPager2
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class CertMissionActivity : AppCompatActivity() {
    companion object {
        lateinit var viewPager: ViewPager2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cert_mission)

        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = ScreenSlidePagerAdapter(this)
    }

    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> CertMissionFragment()
                1 -> PickThemeFragment()
                2 -> PickedThemeFragment()
                else -> throw error("Invalid position $position")
            }
        }
    }
}