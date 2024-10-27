package com.project.olol.presentation.ui.mission

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.project.olol.R
import com.project.olol.databinding.FragmentPickThemeBinding
import com.project.olol.presentation.ui.main.MainActivity

class PickThemeFragment : Fragment() {
    private lateinit var binding: FragmentPickThemeBinding
    private var selectedButton: LinearLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPickThemeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val themeButtons = listOf(
            binding.themeButton1,
            binding.themeButton2,
            binding.themeButton3,
            binding.themeButton4,
            binding.themeButton5,
            binding.themeButton6,
            binding.themeButton7,
            binding.themeButton8
        )

        themeButtons.forEach { button ->
            button.setOnClickListener {
                updateButtonSelection(button)
            }
        }

        binding.btnGotoPickedtheme.setOnClickListener {
            if (binding.btnGotoPickedtheme.text == "이미지 생성하기") {
                CertMissionActivity.viewPager.currentItem = 2
            } else {
                activity?.finish()
                startActivity(Intent(activity, MainActivity::class.java))
            }
        }
    }

    private fun updateButtonSelection(selected: LinearLayout) {
        selectedButton?.isSelected = false
        selectedButton = selected
        selectedButton?.isSelected = true

        binding.btnGotoPickedtheme.apply {
            text = "이미지 생성하기"
            setBackgroundResource(R.drawable.bg_round_main) // 배경 변경
        }
    }
}