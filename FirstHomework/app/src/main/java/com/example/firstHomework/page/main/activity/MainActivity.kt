package com.example.firstHomework.page.main.activity

import android.os.Bundle
import android.view.KeyEvent
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
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        return super.onKeyDown(keyCode, event)
    }
}