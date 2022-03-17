package com.example.secondhomework.page

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.secondhomework.R
import com.example.secondhomework.widget.MyProgressBar
import java.text.FieldPosition
import java.util.*

/**
 *@author:created by $[poisunk]
 *邮箱：1714480752@qq.com
 */
class MyRecylcerAdapter(val list:MutableList<Runnable>,val context: Context):
    RecyclerView.Adapter<MyRecylcerAdapter.ViewHolder>() , ItemTouchHelperAdapterCallback {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_task,parent,false))

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.progressNum.text= (position+1).toString()
        val progress:Int=(Math.random()*100).toInt()
        holder.progressBar.setProgress(progress)
        holder.progressInfo.text= "$progress%"
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        val progressBar:MyProgressBar = view.findViewById(R.id.item_progress_bar)

        val progressNum:TextView = view.findViewById(R.id.item_progress_num)

        val progressInfo:TextView = view.findViewById(R.id.item_progress_info)

    }

    override fun onItemMove(fromPosition: Int, targetPosition: Int): Boolean {
        Collections.swap(list,fromPosition,targetPosition)
        notifyItemMoved(fromPosition,targetPosition)
        return true
    }

    override fun onItemSwiped(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }


}