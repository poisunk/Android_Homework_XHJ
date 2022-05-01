package com.example.thirdhomework.page.main.widget

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.example.thirdhomework.R

/**
 *创建者： poisunk
 *邮箱：1714480752@qq.com
 */

@SuppressLint("AppCompatCustomView", "ObjectAnimatorBinding")
class MyView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : TextView(context ,attrs ,defStyleAttr ,defStyleRes) {

    private val TAG = "MyView"

    private var mLastX = 0f
    private var mLastY = 0f

    private var mTop = 0f


    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        mTop = top.toFloat()
        super.onLayout(changed, left, top, right, bottom)
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                mLastX = event.x
                mLastY = event.y
            }
            MotionEvent.ACTION_MOVE -> {
                val moveX = event.x - mLastX
                val moveY = event.y - mLastY

//                translationY = moveY
//                translationX = moveX

                offsetLeftAndRight(moveX.toInt())
                offsetTopAndBottom(moveY.toInt())

//                Log.d(TAG,"$mTop : "+this.top + " : " + event.rawY)

                val rate = if(this.top.toFloat()/mTop > 0.5f){
                    this.top/mTop
                }else{
                    0.5f
                }
                this.scaleX = rate
                this.scaleY = rate
                this.alpha = rate
            }
            MotionEvent.ACTION_UP -> {
            }
        }
        return true
    }
}