package com.example.asraviation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.asraviation.databinding.FragmentBookingClientBinding
import com.example.asraviation.databinding.FragmentFragOperatorBookingBinding
import com.example.asraviation.operator.Booking
import com.example.asraviation.operator.BookingAdapter

class Booking_Client_Frag : Fragment() {

    private var _binding: FragmentBookingClientBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: BookingClientAdapter
    private val bookingList = ArrayList<BookingClient>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookingClientBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView(requireContext())
        loadBookingData()
    }

    private fun setupRecyclerView(context: Context) {
        // Set up RecyclerView layout and adapter
        adapter = BookingClientAdapter(bookingList,context)
        binding.recyclerViewBookings.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewBookings.adapter = adapter
    }

    private fun loadBookingData() {
        // Add two dummy data items
        bookingList.add(BookingClient("Jaipur","Delhi","Gulfstream G500","360000",1,"12/08/2023"))
        bookingList.add(BookingClient("Vadodara","Jaipur","Falcon 2000LX","400000",2,"10/01/2023"))
        bookingList.add(BookingClient("Delhi","Jaipur","Gulfstream G500","360000",3,"1/10/2023"))
        adapter.notifyDataSetChanged()
    }

}