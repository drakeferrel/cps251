package com.ebookfrenzy.roomdemo.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.roomdemo.Contact
import com.ebookfrenzy.roomdemo.R


class ContactListAdapter(
    private val productItemLayout: Int,
    var listener: OnTextClickListener?
) :  RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private var contactList: List<Contact>? = null

    interface OnTextClickListener {
        fun onTextClick(data: String)
    }

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        contactList.let {
            holder.contactName.text = it!![listPosition].contactName
            holder.phoneNumber.text = it!![listPosition].phoneNumber

            holder.deleteImage.setOnClickListener {
                listener?.onTextClick(holder.contactName.text.toString())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            productItemLayout, parent, false)
        return ViewHolder(view)
    }

    fun setProductList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var contactName: TextView = itemView.findViewById(R.id.name)
        var phoneNumber: TextView = itemView.findViewById(R.id.phoneNumber)
        var deleteImage: ImageView = itemView.findViewById(R.id.imageView)

        /*
        init {
            deleteImage.setOnClickListener {
            }
        }
         */
    }
}