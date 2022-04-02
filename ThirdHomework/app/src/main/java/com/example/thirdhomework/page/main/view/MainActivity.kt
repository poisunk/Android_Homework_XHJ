package com.example.thirdhomework.page.main.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginBottom
import androidx.core.view.marginTop
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thirdhomework.R
import com.example.thirdhomework.page.main.adapter.MyRecyclerAdapter
import com.example.thirdhomework.page.main.view.fragments.TestFragment1
import com.example.thirdhomework.page.main.view.fragments.TestFragment2
import kotlinx.android.synthetic.main.learn_behavior.*

/**
 *创建者： poisunk
 *邮箱：1714480752@qq.com
 */
class MainActivity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(TestFragment1())
    }

    private fun replaceFragment(fragment:Fragment){
        val ft = fragmentManager.beginTransaction()
        ft.replace(R.id.activity_main,fragment)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu1 -> {
                replaceFragment(TestFragment1())
            }
            R.id.menu2 -> {
                replaceFragment(TestFragment2())
            }
        }

        return super.onOptionsItemSelected(item)
    }
}