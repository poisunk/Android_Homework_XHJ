package com.example.thirdhomework.page.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginBottom
import androidx.core.view.marginTop
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thirdhomework.R
import com.example.thirdhomework.page.main.adapter.MyRecyclerAdapter
import kotlinx.android.synthetic.main.learn_behavior.*

/**
 *创建者： poisunk
 *邮箱：1714480752@qq.com
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn_behavior)
        initRecycler()

    }

    private fun initRecycler(){
        val data:MutableList<Int> = ArrayList()
        for(i:Int in 1..(Math.random()*50).toInt()){
            data.add((Math.random()*100).toInt())
        }
        recycler_view.adapter = MyRecyclerAdapter(data)
        recycler_view.layoutManager = LinearLayoutManager(this)
    }
}