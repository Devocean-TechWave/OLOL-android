package com.project.olol.presentation.ui.my

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.project.olol.databinding.FragmentMyBinding

class MyFragment : Fragment() {
    private var _binding: FragmentMyBinding? = null
    private val binding get() = _binding!!

    private lateinit var permissionLauncher: ActivityResultLauncher<String>
    private lateinit var imagePickerLauncher: ActivityResultLauncher<Intent>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyBinding.inflate(inflater, container, false)

        // 권한 요청 런처 설정
        permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                pickImageFromGallery()
            } else {
                Toast.makeText(requireContext(), "이미지 권한을 허용해주세요!", Toast.LENGTH_SHORT).show()
            }
        }

        // 이미지 선택 런처 설정
        imagePickerLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == android.app.Activity.RESULT_OK) {
                val selectedImageUri: Uri? = result.data?.data
                selectedImageUri?.let {
                    binding.btnUploadImage.setImageURI(it)
                }
            }
        }

        // 이미지 클릭 시 권한 확인 후 이미지 선택
        binding.btnUploadImage.setOnClickListener {
            checkPermissionAndPickImage()
        }

        // '1대1 문의하기' 버튼 클릭 시 TosActivity로 이동
        binding.btnGoto1on1.setOnClickListener {
            val intent = Intent(requireContext(), TosActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    // 권한 확인 및 이미지 선택 처리
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
