package com.example.thirdhomework.page.main.behavior

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.view.marginBottom
import androidx.core.view.marginTop

/**
 *创建者： poisunk
 *邮箱：1714480752@qq.com
 */
class MyHeadViewBehavior(private val context: Context,
                         private val attr: AttributeSet?)
    :CoordinatorLayout.Behavior<View>(context,attr) {

    constructor(context: Context) : this(context,null)

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: View,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    //HeadView是否隐藏
    private var hide = false

    override fun onNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: View,
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int,
        consumed: IntArray
    ) {
        val animator = child.animate()
        val h = child.measuredHeight + child.marginBottom + child.marginTop   //计算出需要移动的高度
        animator.duration = 500
        if (hide){
            if (dyConsumed < 0){
                animator.translationY(0f).start()
                hide = false
            }
        }else {
            if (dyConsumed > 0) {
                animator.translationY(-h.toFloat()).start()
                hide = true
            }
        }

    }

}