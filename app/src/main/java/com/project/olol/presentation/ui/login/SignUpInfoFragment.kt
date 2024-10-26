package com.project.olol.presentation.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import androidx.core.widget.addTextChangedListener
import com.project.olol.R
import com.project.olol.databinding.FragmentSignUpInfoBinding

class SignUpInfoFragment : Fragment() {

    lateinit var binding: FragmentSignUpInfoBinding
    lateinit var loginActivity: LoginActivity

    var gender = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSignUpInfoBinding.inflate(layoutInflater)
        loginActivity = activity as LoginActivity

        binding.run {

            textViewNicknameError.visibility = View.INVISIBLE

            editTextName.addTextChangedListener {
                if(editTextName.text.isNotEmpty()) {
                    editTextName.setBackgroundResource(R.drawable.background_edittext_selected)
                } else {
                    editTextName.setBackgroundResource(R.drawable.background_edittext_unselected)
                }
                checkEnable()
            }

            editTextNickname.addTextChangedListener {
                if(editTextNickname.text.isNotEmpty()) {
                    editTextNickname.setBackgroundResource(R.drawable.background_edittext_selected)
                } else {
                    editTextNickname.setBackgroundResource(R.drawable.background_edittext_unselected)
                }
                checkEnable()
            }

            // Setting up Year Picker
            yearPicker.minValue = 1900
            yearPicker.maxValue = 2024
            yearPicker.value = 2000 // Set initial value to 1998

            // Setting up Month Picker
            monthPicker.minValue = 1
            monthPicker.maxValue = 12
            monthPicker.value = 1 // Set initial value to November

            // Setting up Day Picker
            dayPicker.minValue = 1
            dayPicker.maxValue = 31
            dayPicker.value = 1 // Set initial value to 12

            // Optional: Customize the displayed text format
            yearPicker.setFormatter { value -> "$value 년" }
            monthPicker.setFormatter { value -> "$value 월" }
            dayPicker.setFormatter { value -> "$value 일" }

            // Style adjustments (if needed) for making text bold, centered, etc.
            customizePicker(yearPicker)
            customizePicker(monthPicker)
            customizePicker(dayPicker)

            buttonMale.setOnClickListener {
                if(gender == "") {
                    buttonMale.setBackgroundResource(R.drawable.background_button_signup_selected)
                } else if(gender == "female") {
                    buttonMale.setBackgroundResource(R.drawable.background_button_signup_unselected)
                }

                gender = "male"
                checkEnable()
            }

            buttonFemale.setOnClickListener {
                if(gender == "") {
                    buttonFemale.setBackgroundResource(R.drawable.background_button_signup_selected)
                } else if(gender == "male") {
                    buttonFemale.setBackgroundResource(R.drawable.background_button_signup_unselected)
                }

                gender = "female"
                checkEnable()
            }


            buttonNext.setOnClickListener {
            }
        }

        return binding.root
    }

    fun checkEnable() {
        binding.run {
            if(gender != "" && editTextName.text.isNotEmpty() && editTextNickname.text.isNotEmpty()) {
                buttonNext.isEnabled = true
            } else {
                buttonNext.isEnabled = false
            }
        }
    }


    private fun customizePicker(picker: NumberPicker) {
        // You can set additional customization here if needed, such as changing text size, color, etc.
        picker.wrapSelectorWheel = true
    }
}