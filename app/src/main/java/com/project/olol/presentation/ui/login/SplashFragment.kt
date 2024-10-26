package com.project.olol.presentation.ui.login

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.olol.R
import com.project.olol.databinding.FragmentSplashBinding
import com.project.olol.presentation.ui.home.HomeFragment

class SplashFragment : Fragment() {

    lateinit var binding: FragmentSplashBinding
    lateinit var loginActivity: LoginActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSplashBinding.inflate(layoutInflater)
        loginActivity = activity as LoginActivity

        binding.run {
            Handler().postDelayed({
                loginActivity.supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView_login, LoginFragment())
                    .commit()
            }, 1000)
        }
        return binding.root
    }
}