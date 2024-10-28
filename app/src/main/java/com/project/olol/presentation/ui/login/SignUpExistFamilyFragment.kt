package com.project.olol.presentation.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.project.olol.R
import com.project.olol.databinding.FragmentSignUpExistFamilyBinding
import com.project.olol.databinding.FragmentSignUpFindFamilyBinding

class SignUpExistFamilyFragment : Fragment() {

    lateinit var binding: FragmentSignUpExistFamilyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSignUpExistFamilyBinding.inflate(layoutInflater)

        binding.run {
            editTextFamilyName.addTextChangedListener {
                if(editTextFamilyName.text.isNotEmpty()) {
                    editTextFamilyName.setBackgroundResource(R.drawable.background_edittext_selected)
                } else {
                    editTextFamilyName.setBackgroundResource(R.drawable.background_edittext_unselected)
                }
                checkEnable()
            }

            editTextFamilyRole.addTextChangedListener {
                if(editTextFamilyRole.text.isNotEmpty()) {
                    editTextFamilyRole.setBackgroundResource(R.drawable.background_edittext_selected)
                } else {
                    editTextFamilyRole.setBackgroundResource(R.drawable.background_edittext_unselected)
                }
                checkEnable()
            }

            buttonNext.setOnClickListener {

            }
        }

        return binding.root
    }

    fun checkEnable() {
        binding.run {
            if(editTextFamilyName.text.isNotEmpty() && editTextFamilyRole.text.isNotEmpty()) {
                buttonNext.isEnabled = true
            } else {
                buttonNext.isEnabled = false
            }
        }
    }
}