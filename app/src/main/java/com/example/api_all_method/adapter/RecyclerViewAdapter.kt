package com.example.api_all_method.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.api_all_method.R
import com.example.api_all_method.model.User
import kotlinx.android.synthetic.main.item_layout.view.*

class RecyclerViewAdapter(private val list: List<User>, private val itemClick:ItemClick) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(inflater,itemClick)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(private val view: View, private val itemClick:ItemClick) : RecyclerView.ViewHolder(view) {

        fun bind(data: User) {
            view.apply {
                textViewName.text = data.name
                textViewEmail.text = data.email
                textViewStatus.text = data.status

                delete.setOnClickListener{

                 itemClick.deleteData(data.id!!)
                    Log.d("delete",data.id.toString())
                    Toast.makeText(context, "Data deleted", Toast.LENGTH_SHORT).show()
                }
                edit.setOnClickListener{
                    itemClick.updateTheData(data)
                }

            }
        }
    }


}  interface ItemClick {
    fun deleteData(id: Int)
    fun updateTheData(user:User)
}