package com.example.thirdhomework.page.main.behavior

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.widget.Scroller
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.view.marginBottom
import androidx.core.view.marginTop
import com.example.thirdhomework.R

/**
 *创建者： poisunk
 *邮箱：1714480752@qq.com
 */
class MyHeadViewBehavior(
    private val context: Context,
    private val attr: AttributeSet?,
)
    :CoordinatorLayout.Behavior<View>(context,attr) {

    private val TAG = "MyHeadViewBehavior"


    private val mScroller:Scroller = Scroller(context)

    private val scaleAnim:Animation

    init {
        scaleAnim = AnimationUtils.loadAnimation(context, R.anim.scaleanim)
    }

    constructor(context: Context) : this(context,null)

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: View,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int,
    ): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    override fun onNestedScrollAccepted(
        coordinatorLayout: CoordinatorLayout,
        child: View,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ) {
        super.onNestedScrollAccepted(coordinatorLayout,
            child,
            directTargetChild,
            target,
            axes,
            type)

    }

    override fun onNestedPreScroll(
        coordinatorLayout: CoordinatorLayout,
        child: View,
        target: View,
        dx: Int,
        dy: Int,
        consumed: IntArray,
        type: Int,
    ) {
        val h = child.measuredHeight + child.marginBottom + child.marginTop   //计算出需要移动的高度

        child.pivotX = child.measuredWidth.toFloat()/2
        child.pivotY = child.measuredHeight.toFloat()

        if(dy>0) {
            val scrollY = if(coordinatorLayout.scrollY + dy <= h){
                dy
            }else{
                h - coordinatorLayout.scrollY
            }


            child.alpha = 1f - coordinatorLayout.scrollY.toFloat()/h
            child.scaleX = 1f - coordinatorLayout.scrollY.toFloat()/h
            child.scaleY = 1f - coordinatorLayout.scrollY.toFloat()/h

            coordinatorLayout.scrollBy(0, scrollY)
            consumed[1] = scrollY

        }else if(dy<0){
            val scrollY = if(coordinatorLayout.scrollY + dy < 0){
                -coordinatorLayout.scrollY
            }else{
                dy
            }

            child.alpha = 1f - coordinatorLayout.scrollY.toFloat()/h
            child.scaleX = 1f - coordinatorLayout.scrollY.toFloat()/h
            child.scaleY = 1f - coordinatorLayout.scrollY.toFloat()/h

            coordinatorLayout.scrollBy(0, scrollY)
            consumed[1] = scrollY
        }

        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
    }

//    override fun onStopNestedScroll(
//        coordinatorLayout: CoordinatorLayout,
//        child: View,
//        target: View,
//        type: Int
//    ) {
//        val h = child.measuredHeight + child.marginBottom + child.marginTop
//        if(coordinatorLayout.scrollY >= h/2){
//            val alphaAnimation = ObjectAnimator.ofFloat(child,"alpha",child.alpha,0f)
//            val scaleXAnimation = ObjectAnimator.ofFloat(child,"scaleX",child.scaleX,0f)
//            val scaleYAnimation = ObjectAnimator.ofFloat(child,"scaleY",child.scaleY,0f)
//            val animationSet = AnimatorSet()
//            animationSet.playSequentially(alphaAnimation,scaleXAnimation,scaleYAnimation)
//            animationSet.start()
//        }else{
//
//        }
//        super.onStopNestedScroll(coordinatorLayout, child, target, type)
//    }

}