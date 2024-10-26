package com.project.olol.presentation.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.olol.R
import com.project.olol.databinding.FragmentSignUpFindFamilyBinding

class SignUpFindFamilyFragment : Fragment() {

    lateinit var binding: FragmentSignUpFindFamilyBinding
    lateinit var loginActivity: LoginActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSignUpFindFamilyBinding.inflate(layoutInflater)
        loginActivity = activity as LoginActivity

        binding.run {
            buttonExist.setOnClickListener {
                loginActivity.supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView_login, SignUpExistFamilyFragment())
                    .commit()
            }

            buttonNotExist.setOnClickListener {
                loginActivity.supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView_login, SignUpNotExistFamilyFragment())
                    .commit()
            }
        }

        return binding.root
    }
}