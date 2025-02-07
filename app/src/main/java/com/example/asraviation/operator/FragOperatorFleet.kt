package com.example.asraviation.operator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.asraviation.R
import com.example.asraviation.databinding.FragmentFragOperatorAnallyticsBinding
import com.example.asraviation.databinding.FragmentFragOperatorFleetBinding

class FragOperatorFleet : Fragment() {

    private var _binding: FragmentFragOperatorFleetBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFragOperatorFleetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //button logic
        binding.btnaddfleet.setOnClickListener {
            Toast.makeText(context, "Add Fleet Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Avoid memory leaks
    }

}