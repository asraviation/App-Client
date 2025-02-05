package com.example.asraviation

data class BookingClient(
    val src: String,
    val dest: String,
    val fleetname: String,
    val price: String,
    val stcheck: Int,
    val date: String
)
