package com.project.olol.presentation.ui.mission

import android.Manifest
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.project.olol.R
import com.project.olol.databinding.FragmentCertMissionBinding

class CertMissionFragment : Fragment() {
    private var _binding: FragmentCertMissionBinding? = null
    private val binding get() = _binding!!

    private lateinit var permissionLauncher: ActivityResultLauncher<String>
    private lateinit var imagePickerLauncher: ActivityResultLauncher<Intent>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCertMissionBinding.inflate(inflater, container, false)

        permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                pickImageFromGallery()
            } else {
                Toast.makeText(requireContext(), "이미지 권한을 허용해주세요!", Toast.LENGTH_SHORT).show()
            }
        }

//        imagePickerLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//            if (result.resultCode == android.app.Activity.RESULT_OK) {
//                        val selectedImageUri: Uri? = result.data?.data
//                        selectedImageUri?.let { uri ->
//                            binding.btnUploadImage.apply {
//                                background = null
//                                setBackgroundColor(0)
//                                background = BitmapDrawable(resources, MediaStore.Images.Media.getBitmap(context.contentResolver, uri))
//                                binding.icImageUpload.visibility = View.GONE
//                        binding.txImageUpload.visibility = View.GONE
//                    }
//                }
//            }
//        }\\

        imagePickerLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == android.app.Activity.RESULT_OK) {
                val selectedImageUri: Uri? = result.data?.data
                selectedImageUri?.let { uri ->
                    binding.btnUploadImage.apply {
                        background = null
                        setBackgroundColor(0)
                        background = BitmapDrawable(resources, MediaStore.Images.Media.getBitmap(context.contentResolver, uri))
                        binding.icImageUpload.visibility = View.GONE
                         binding.txImageUpload.visibility = View.GONE
                    }

                    binding.btnGotoPicktheme.apply {
                        setBackgroundResource(R.drawable.bg_round_main)
                        text = "다음으로"
                    }
                }
            }
        }


        binding.btnUploadImage.setOnClickListener {
            checkPermissionAndPickImage()
        }

        return binding.root
    }

    private fun checkPermissionAndPickImage() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { // Android 13 이상일 경우
            permissionLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES)
        } else { // Android 13 미만일 경우
            permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        imagePickerLauncher.launch(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}