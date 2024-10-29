package com.project.olol.presentation.ui.mission

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.fragment.app.Fragment
import com.project.olol.R
import com.project.olol.databinding.FragmentPickedThemeBinding
import com.project.olol.presentation.ui.main.MainActivity

class PickedThemeFragment : Fragment() {

    private var _binding: FragmentPickedThemeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPickedThemeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textSizeAnimator = ObjectAnimator.ofFloat(binding.txAnimated, "textSize", 205f, 195f).apply {
            duration = 1500
            interpolator = LinearInterpolator()
            repeatMode = ObjectAnimator.REVERSE
            repeatCount = ObjectAnimator.INFINITE
        }
        textSizeAnimator.start()

        binding.btnGotoHome.setOnClickListener {
            activity?.finish()
            startActivity(Intent(activity, MainActivity::class.java))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}