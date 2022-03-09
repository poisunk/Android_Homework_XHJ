package com.example.firstHomework.base

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import androidx.appcompat.app.AppCompatActivity

/**
 *@author:created by $[poisunk]
 *邮箱：1714480752@qq.com
 */
abstract class BaseActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cancelStatusBar()
    }

    /**
     * 取消状态栏
     */
    private fun cancelStatusBar() {
        val window = window
        val decorView = window.decorView
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // 取消状态栏
            window.setDecorFitsSystemWindows(false)
            // 状态栏字体颜色变黑
            decorView.windowInsetsController!!.setSystemBarsAppearance(
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
            )
        } else {
            // 取消状态栏，已经做了判断使用
            val option = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
            decorView.systemUiVisibility = option
            // 状态栏字体颜色变黑
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or option
            }
        }
        window.statusBarColor = Color.TRANSPARENT // 把状态栏颜色设置成透明
    }

}