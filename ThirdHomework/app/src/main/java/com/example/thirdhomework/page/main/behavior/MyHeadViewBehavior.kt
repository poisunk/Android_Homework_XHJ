package com.example.thirdhomework.page.main.behavior

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewGroup
import android.widget.Scroller
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.view.marginBottom
import androidx.core.view.marginTop
import kotlin.math.abs

/**
 *创建者： poisunk
 *邮箱：1714480752@qq.com
 */
class MyHeadViewBehavior(private val context: Context,
                         private val attr: AttributeSet?)
    :CoordinatorLayout.Behavior<View>(context,attr) {

    //HeadView是否隐藏
    private var hide = false

    private val mScroller:Scroller = Scroller(context)

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


//    private var mLastY:Float = 0f
//
//    override fun onInterceptTouchEvent(
//        parent: CoordinatorLayout,
//        child: View,
//        ev: MotionEvent
//    ): Boolean {
//        when(ev.action){
//            MotionEvent.ACTION_DOWN -> {
//                Log.d("onInterceptTouchEvent","ACTION_DOWN")
//                mLastY = ev.rawY
//            }
//            MotionEvent.ACTION_MOVE -> {
//                Log.d("onInterceptTouchEvent","ACTION_MOVE")
//
//                return true
//            }
//        }
//        return super.onInterceptTouchEvent(parent, child, ev)
//    }
//
//
//    override fun onTouchEvent(parent: CoordinatorLayout, child: View, ev: MotionEvent): Boolean {
//        val h = child.measuredHeight + child.marginBottom + child.marginTop   //计算出需要移动的高度
//
//        when(ev.action){
//            MotionEvent.ACTION_DOWN -> {
//                Log.d("onTouchEvent","ACTION_DOWN")
//            }
//            MotionEvent.ACTION_MOVE -> {
//                Log.d("onTouchEvent","ACTION_MOVE")
//                val moveY = ev.rawY - mLastY
//                child.offsetTopAndBottom(moveY.toInt())
//                mLastY = ev.rawY
//            }
//        }
//
//        return true
//    }



}