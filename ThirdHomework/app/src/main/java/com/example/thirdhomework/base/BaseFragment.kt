package com.example.thirdhomework.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 *创建者： poisunk
 *邮箱：1714480752@qq.com
 */
open class BaseFragment(private val resource:Int) :Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(resource, container, false)
    }
}