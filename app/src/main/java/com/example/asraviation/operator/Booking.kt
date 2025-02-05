package com.example.asraviation.operator

data class Booking (
    val passengername:String,
    val source:String,
    val destination:String,
    val seat: Int,
    val price: Int,
    val taxi: Boolean,
    val meal: String,
    val time: String
)