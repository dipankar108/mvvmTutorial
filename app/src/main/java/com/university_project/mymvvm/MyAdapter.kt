package com.university_project.mymvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter() : RecyclerView.Adapter<MyAdapter.NameListViewHolder>() {
    private var nameList = ArrayList<String>()

    class NameListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameView: TextView = itemView.findViewById(R.id.tv_nameView_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameListViewHolder {
        val viewHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.nameitemview, parent, false)
        return NameListViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: NameListViewHolder, position: Int) {
        holder.nameView.text = nameList[position]
    }

    override fun getItemCount(): Int {
        return nameList.size
    }

    fun setValueToArray(arraylist: ArrayList<String>) {
        nameList= arraylist
    }
}