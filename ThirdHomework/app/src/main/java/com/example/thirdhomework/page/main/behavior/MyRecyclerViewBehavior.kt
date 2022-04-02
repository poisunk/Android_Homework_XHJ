package com.example.thirdhomework.page.main.behavior

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.cardview.widget.CardView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.marginBottom
import androidx.core.view.marginTop

/**
 *创建者： poisunk
 *邮箱：1714480752@qq.com
 */
class MyRecyclerViewBehavior(private val context: Context,
                             private val attr: AttributeSet?)
    : CoordinatorLayout.Behavior<View>(context,attr)  {

    constructor(context: Context):this(context,null)

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        return dependency is CardView
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        val h = dependency.measuredHeight + dependency.marginBottom
        child.y = dependency.y + h.toFloat()
        return true
    }


}