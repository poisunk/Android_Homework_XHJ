package com.example.secondhomework.page

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.secondhomework.R
import com.example.secondhomework.widget.MyProgressBar

/**
 *@author:created by $[poisunk]
 *邮箱：1714480752@qq.com
 */
class MyRecylcerAdapter(val list:MutableList<Runnable>,val context: Context):RecyclerView.Adapter<MyRecylcerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_task,parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.progressNum.text= (position+1).toString()
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        val progressBar:MyProgressBar = view.findViewById(R.id.item_progress_bar)

        val progressNum:TextView = view.findViewById(R.id.item_progress_num)
    }

}