package com.example.thirdhomework.page.main.widget

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.TextView

/**
 *创建者： poisunk
 *邮箱：1714480752@qq.com
 */

@SuppressLint("AppCompatCustomView")
class MyView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
)
    : TextView(context ,attrs ,defStyleAttr ,defStyleRes) {

    private var mLastX = 0f
    private var mLastY = 0f


    override fun onTouchEvent(event: MotionEvent): Boolean {
        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                Log.d("MY_VIEW:onTouchEvent", "DOWN")
                mLastX = event.x
                mLastY = event.y
            }
            MotionEvent.ACTION_MOVE -> {
                Log.d("MY_VIEW:onTouchEvent", "MOVE")
                val moveX = event.x - mLastX
                val moveY = event.y - mLastY

//                translationY = moveY
//                translationX = moveX

                offsetLeftAndRight(moveX.toInt())
                offsetTopAndBottom(moveY.toInt())
            }
            MotionEvent.ACTION_UP -> {

            }
        }
        return true
    }

    override fun computeScroll() {
        super.computeScroll()
    }
}