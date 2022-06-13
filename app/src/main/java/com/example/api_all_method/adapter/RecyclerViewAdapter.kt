package com.example.api_all_method.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api_all_method.R
import com.example.api_all_method.model.User
import kotlinx.android.synthetic.main.item_layout.view.*

class RecyclerViewAdapter() : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var userList = mutableListOf<User>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class MyViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(data: User) {
            view.apply {
                textViewName.text=data.name
                textViewEmail.text=data.email
                textViewStatus.text=data.status
            }
        }
    }

}