package com.example.getapi

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list.view.*

class MainAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomViewHolder>() {
    override fun getItemCount(): Int {
        return homeFeed.motors.count()
    }

//    val videoTitles = listOf("First title", "Second", "3rd", "MOOOOORE TITLE")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.list, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
//        val videoTitle = videoTitles.get(position)
        val motorsItem = homeFeed.motors.get(position)
        holder.view.nama.text = motorsItem.getName
        holder.view.idmotor.text = motorsItem.getId
        holder.view.harga.text = motorsItem.getHargaJual
        holder.view.kategori.text = motorsItem.getMotorCategoryId
        holder.view.thn.text = motorsItem.getThnMotor

    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {
}
