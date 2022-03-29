package com.example.thirdhomework.page.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thirdhomework.R

/**
 *创建者： poisunk
 *邮箱：1714480752@qq.com
 */
class MyRecyclerAdapter(val data:List<Int>) : RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>() {



    inner class ViewHolder( v: View):RecyclerView.ViewHolder(v){
        val textView: TextView =v.findViewById(R.id.item_recycler_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = data[position].toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }
}