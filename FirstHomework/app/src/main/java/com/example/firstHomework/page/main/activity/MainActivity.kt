package com.example.firstHomework.page.main.activity

import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import com.example.firstHomework.R
import com.example.firstHomework.base.BaseActivity
import com.example.firstHomework.page.playlist.view.PlaylistFragment

class MainActivity : BaseActivity() {

    private val fragmentManager=supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.activity_main,PlaylistFragment(),"PlaylistFragment")
        fragmentTransaction.addToBackStack("PlaylistFragment")
        fragmentTransaction.commit()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 获取当前回退栈中的Fragment个数
            val backStackEntryCount = fragmentManager.backStackEntryCount
            // 回退栈中至少有多个fragment,栈底部是首页
            if (backStackEntryCount > 1) {
                // 立即回退一步
                fragmentManager.popBackStackImmediate()
            } else {
                //回退栈中只剩一个时,退出应用
                finish()
            }
        }
        return true
    }
}