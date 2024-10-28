package com.project.olol.presentation.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.project.olol.R
import com.project.olol.databinding.FragmentSignUpExistFamilyBinding
import com.project.olol.databinding.FragmentSignUpNotExistFamilyBinding

class SignUpNotExistFamilyFragment : Fragment() {
    lateinit var binding: FragmentSignUpNotExistFamilyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSignUpNotExistFamilyBinding.inflate(layoutInflater)

        binding.run {

            textViewFamilyNameError.visibility = View.INVISIBLE
            
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

            buttonMakeFamily.setOnClickListener {

            }
        }

        return binding.root
    }

    fun checkEnable() {
        binding.run {
            if(editTextFamilyName.text.isNotEmpty() && editTextFamilyRole.text.isNotEmpty()) {
                buttonMakeFamily.isEnabled = true
            } else {
                buttonMakeFamily.isEnabled = false
            }
        }
    }
}