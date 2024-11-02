package com.project.olol.presentation.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.olol.R
import com.project.olol.databinding.FragmentHomeBinding
import com.project.olol.presentation.ui.mission.CertMissionActivity

class HomeFragment: Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var onGoToAlbumListener: OnGoToAlbumListener? = null

    interface OnGoToAlbumListener {
        fun onGoToAlbum()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnGoToAlbumListener) {
            onGoToAlbumListener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGotoMission.setOnClickListener {
            val intent = Intent(requireContext(), CertMissionActivity::class.java)
            startActivity(intent)
        }

        binding.btnGotoAlbum.setOnClickListener {
            onGoToAlbumListener?.onGoToAlbum()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}