package com.example.apicall

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ApiAdapter (private val context:Context, private val informations: List<Information>):
        RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false)
        return MyViewHolder(view)
    }
    override fun getItemCount(): Int {
        return informations.size
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val information = informations[position]
        holder.name.text = information.name
        holder.email.text = information.email
        holder.gender.text = information.gender
        holder.status.text = information.status
    }



}
class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
var name: TextView = itemView.findViewById(R.id.name)
var email: TextView = itemView.findViewById(R.id.email)
var gender: TextView = itemView.findViewById(R.id.gender)
var status: TextView = itemView.findViewById(R.id.status)
}