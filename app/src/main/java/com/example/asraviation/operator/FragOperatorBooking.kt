package com.example.asraviation.operator

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.asraviation.R
import com.example.asraviation.databinding.FragmentFragOperatorBookingBinding

class FragOperatorBooking : Fragment() {
    private var _binding: FragmentFragOperatorBookingBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: BookingAdapter
    private val bookingList = ArrayList<Booking>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFragOperatorBookingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView(requireContext())
        loadBookingData()


    }

    private fun setupRecyclerView(context: Context) {
        // Set up RecyclerView layout and adapter
        adapter = BookingAdapter(bookingList,context)
        binding.recyclerViewBookings.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewBookings.adapter = adapter
    }

    private fun loadBookingData() {
        // Add two dummy data items
        bookingList.add(Booking("Rahul Sharma","DEL","JPR",3,367890,false,"Veg","12:00 AM"))
        bookingList.add(Booking("Priya Jain","AHM","BOM",1,200000,true,"Non Veg","1:50 PM"))
        bookingList.add(Booking("Veer Jain","JPR","DEl",5,1367890,true,"Veg","10:00 AM"))


        // Notify the adapter about data changes
        adapter.notifyDataSetChanged()
    }
}