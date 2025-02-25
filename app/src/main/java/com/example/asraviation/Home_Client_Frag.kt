package com.example.asraviation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.asraviation.databinding.FragmentHomeClientBinding

class Home_Client_Frag : Fragment() {
    private var _binding: FragmentHomeClientBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initialize binding with inflater
        _binding = FragmentHomeClientBinding.inflate(inflater, container, false)

        binding.clicktxt.setOnClickListener {
            startActivity(Intent(requireContext(), ClinetBookSumarry::class.java))
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Avoid memory leaks
    }
}