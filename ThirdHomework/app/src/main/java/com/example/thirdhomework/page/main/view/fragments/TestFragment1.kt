package com.example.thirdhomework.page.main.view.fragments

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thirdhomework.base.BaseFragment
import com.example.thirdhomework.R
import com.example.thirdhomework.page.main.adapter.MyRecyclerAdapter
import kotlinx.android.synthetic.main.learn_behavior.*
import java.sql.Time
import kotlin.random.Random

/**
 *创建者： poisunk
 *邮箱：1714480752@qq.com
 */
class TestFragment1(private val resource:Int = R.layout.learn_behavior) : BaseFragment(resource){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initRecycler()
    }

    private fun initRecycler(){
        val data:MutableList<Int> = ArrayList()
        for(i:Int in 1..(50+ Math.random()*50).toInt()){
            data.add((Math.random()*100).toInt())
        }
        recycler_view.adapter = MyRecyclerAdapter(data)
        recycler_view.layoutManager = LinearLayoutManager(requireContext())
    }
}