package com.example.secondhomework.page

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.secondhomework.R
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log.d as d1

class MainActivity : AppCompatActivity() , View.OnClickListener {

    val list:MutableList<Runnable> = ArrayList()
    val adapter:MyRecylcerAdapter by lazy { MyRecylcerAdapter(list,this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list_task.adapter=adapter
        list_task.layoutManager=LinearLayoutManager(this)
        button_add.setOnClickListener(this)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button_add ->{
                d1("Main","add")
                list.add {}
                adapter.notifyDataSetChanged()
            }
        }
    }
}