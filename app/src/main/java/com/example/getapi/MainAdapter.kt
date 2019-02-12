package com.example.getapi

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list.view.*

class MainAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomViewHolder>() {
    override fun getItemCount(): Int {
        return homeFeed.motors.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.list, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(homeFeed!![position])
    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    
    fun bind(model: HomeFeed) = with(itemView) {
        nama.text = model.name
        idmotor.text = model.id
        harga.text = model.harga_jual
        kategori.text = model.motor_category_id
        thn.text = model.thn_motor
        
    }
}
