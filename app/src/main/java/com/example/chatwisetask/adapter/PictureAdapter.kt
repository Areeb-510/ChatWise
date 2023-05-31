package com.example.chatwisetask.adapter

import android.graphics.Picture
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chatwisetask.R

class PictureAdapter : RecyclerView.Adapter<PictureAdapter.PictureViewHolder>() {

    private var dataList: List<com.example.chatwisetask.data.Picture> = emptyList()

    inner class PictureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView : ImageView = itemView.findViewById(R.id.show_image)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_picture, parent, false)
        return PictureViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        val data = dataList[position]
        Glide.with(holder.itemView)
            .load(data.url)
            .into(holder.imageView)
    }

    fun setData(newDataList: List<com.example.chatwisetask.data.Picture>) {
        dataList = newDataList
        notifyDataSetChanged()
    }

}