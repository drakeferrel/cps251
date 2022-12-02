package com.ebookfrenzy.recycleview

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

import com.google.android.material.snackbar.Snackbar
import androidx.core.content.ContextCompat.startActivity
import android.content.Intent

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return Data.titles.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = Data.titles[MainViewModel.randomizedTitle[i]]
        viewHolder.itemDetail.text = Data.details[MainViewModel.randomizedDetail[i]]
        viewHolder.itemImage.setImageResource(Data.images[MainViewModel.randomizedImageId[i]])
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener { v: View  ->
                val intent = Intent(v.context,MainActivity2::class.java)


                intent.putExtra("title", Data.titles[MainViewModel.randomizedTitle[adapterPosition]])
                intent.putExtra("detail", Data.details[MainViewModel.randomizedDetail[adapterPosition]])
                intent.putExtra("imageId", Data.images[MainViewModel.randomizedImageId[adapterPosition]])

                startActivity(v.context,intent,null)
            }
        }
    }
}