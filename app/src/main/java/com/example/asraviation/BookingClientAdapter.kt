package com.example.asraviation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.asraviation.databinding.BookingItemBinding
import com.example.asraviation.databinding.BookinghistoryClientBinding
import com.example.asraviation.operator.Booking
import com.example.asraviation.operator.BookingAdapter

class BookingClientAdapter (var datalist: ArrayList<BookingClient>, var context: Context) : RecyclerView.Adapter<BookingClientAdapter.MyViewHolder>(){
    inner class MyViewHolder(var binding: BookinghistoryClientBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingClientAdapter.MyViewHolder {
        var binding=BookinghistoryClientBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: BookingClientAdapter.MyViewHolder, position: Int) {
        holder.binding.txtsrc.text=datalist.get(position).src
        holder.binding.txtdest.text=datalist.get(position).dest
        holder.binding.txtfleetname.text=datalist.get(position).fleetname
        holder.binding.txtprice.text=datalist.get(position).price
        holder.binding.txtdate.text=datalist.get(position).date

        if(datalist[position].stcheck==0){
            holder.binding.txtstatus.text="Completed"
            holder.binding.txtstatus.setTextColor(context.resources.getColor(R.color.green))
        }
        else if(datalist[position].stcheck==1){
            holder.binding.txtstatus.text="Pending"
            //to set colour of text to yellow
            holder.binding.txtstatus.setTextColor(context.resources.getColor(R.color.yellow))
        }
        else{
            holder.binding.txtstatus.text="Cancelled"
            holder.binding.txtstatus.setTextColor(context.resources.getColor(R.color.red))
        }

        holder.binding.btnrebook.setOnClickListener {
            Toast.makeText(context, "Rebook", Toast.LENGTH_SHORT).show()

        }


    }
}