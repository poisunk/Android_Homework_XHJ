package com.example.firstHomework.page.playlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstHomework.R
import com.example.firstHomework.bean.Result
import org.w3c.dom.Text

/**
 *@author:created by $[poisunk]
 *邮箱：1714480752@qq.com
 */
class PlaylistsAdapter(private val fragment:Fragment, private var playlists:List<Result>):
    RecyclerView.Adapter<PlaylistsAdapter.ViewHolder>() {


    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val listName: TextView =view.findViewById(R.id.item_list_cover_title)
        val listCoverImage:ImageView=view.findViewById(R.id.item_list_cover_pic)
        val listTrackCount:TextView=view.findViewById(R.id.item_list_cover_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_cover,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result=playlists[position]
        holder.listName.text=result.name
        holder.listTrackCount.text=countString(result.playCount)
        Glide.with(fragment).load(result.picUrl).into(holder.listCoverImage)

    }

    override fun getItemCount() = playlists.size

    private fun countString(count: Long): String {
        return if (count == 0L) {
            "0"
        } else if (count < 10000) {
            count.toString()
        } else if (count < 10000 * 10000) {
            val start = count / 10000
            val end = count % 10000 / 1000
            if (end == 0L) {
                start.toString() + "万"
            } else {
                start.toString() + "." + end + "万"
            }
        } else if (count < 9999L * 10000000) {
            val start = count / 100000000
            val end = count % 100000000 / 10000000
            if (end == 0L) {
                start.toString() + "亿"
            } else {
                start.toString() + "." + end + "亿"
            }
        } else {
            "999.9亿+"
        }
    }
}