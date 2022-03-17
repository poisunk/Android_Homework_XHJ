package com.example.secondhomework.widget

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.secondhomework.R

/**
 *@author:created by $[poisunk]
 *邮箱：1714480752@qq.com
 */
class MyProgressBar(context: Context,attrs:AttributeSet?,defStyleAttr:Int)
    : View(context,attrs,defStyleAttr) {

    private val mPaint:Paint by lazy { Paint(Paint.ANTI_ALIAS_FLAG) }
    private val max:Int
    private var progress:Int

    constructor(context: Context):this(context,null)

    constructor(context: Context,attrs: AttributeSet?):this(context,attrs,0)

    init {
        val array:TypedArray=context.obtainStyledAttributes(attrs, R.styleable.MyProgressBar)
        max = array.getInteger(R.styleable.MyProgressBar_max, 100)
        progress = array.getInteger(R.styleable.MyProgressBar_progress, 0);
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val left_top=Point(0,0)
        val right_bottom=Point(width,height)
        val rate:Double= progress.toDouble()/max.toDouble()
        drawProgressBar(canvas,left_top,right_bottom,rate)
    }

    fun setProgress(progress:Int){
        this.progress=progress
        invalidate()
    }

    fun drawProgressBar(canvas: Canvas?,left_top:Point,right_bottom:Point,rate:Double){
        val width=1f
        val rad=10f
        mPaint.color = Color.BLACK
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = width
        val rectF=RectF(
            left_top.x.toFloat(),
            left_top.y.toFloat(),
            right_bottom.x.toFloat(),
            right_bottom.y.toFloat()
        )
        canvas?.drawRoundRect(rectF, rad, rad, mPaint)

        mPaint.color=Color.WHITE
        mPaint.style=Paint.Style.FILL
        val rectF1=RectF(
            left_top.x.toFloat()-width,
            left_top.y.toFloat()-width,
            right_bottom.x.toFloat()-width,
            right_bottom.y.toFloat()-width
        )
        canvas?.drawRoundRect(rectF1,rad,rad,mPaint)

        mPaint.color=Color.CYAN
        mPaint.style=Paint.Style.FILL
        val rectF2=RectF(
            left_top.x.toFloat()-width,
            left_top.y.toFloat()-width,
            right_bottom.x.toFloat()*rate.toFloat()-width,
            right_bottom.y.toFloat()-width
        )
        canvas?.drawRoundRect(rectF2,rad,rad,mPaint)
    }

}