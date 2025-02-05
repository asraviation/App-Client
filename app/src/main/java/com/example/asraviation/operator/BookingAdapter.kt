package com.example.asraviation.operator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.asraviation.R
import com.example.asraviation.databinding.BookingItemBinding

class BookingAdapter(var datalist: ArrayList<Booking>,var context: Context) : RecyclerView.Adapter<BookingAdapter.MyViewHolder>()  {
    inner class MyViewHolder(var binding:BookingItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding=BookingItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.txtname.text=datalist.get(position).passengername
        holder.binding.txtsrc.text=datalist.get(position).source
        holder.binding.txtdest.text=datalist.get(position).destination
        holder.binding.txtseat.text = datalist[position].seat.toString()
        holder.binding.txtprice.text = datalist[position].price.toString()
        holder.binding.lltaxi.visibility = if (datalist[position].taxi) View.VISIBLE else View.INVISIBLE
        holder.binding.txtmeal.text=datalist.get(position).meal
        holder.binding.txttime.text=datalist.get(position).time

        if (datalist[position].meal=="Non Veg") {
            holder.binding.txtmeal.setTextColor(context.resources.getColor(R.color.red))
        }
        else{
            holder.binding.txtmeal.setTextColor(context.resources.getColor(R.color.green))
        }

        holder.binding.llfleet.setOnClickListener {
            Toast.makeText(context, "Select Fleet ", Toast.LENGTH_SHORT).show()
        }

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "Item Clicked", Toast.LENGTH_SHORT).show()
        }

        holder.binding.btnapprove.setOnClickListener {
            Toast.makeText(context, "Approved", Toast.LENGTH_SHORT).show()
        }

        holder.binding.btnreject.setOnClickListener {
            Toast.makeText(context, "Rejected", Toast.LENGTH_SHORT).show()
        }


    }

}