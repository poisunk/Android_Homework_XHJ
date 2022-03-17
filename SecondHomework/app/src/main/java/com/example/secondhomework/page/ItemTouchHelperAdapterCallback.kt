package com.example.secondhomework.page

import java.text.FieldPosition

/**
 *@author:created by $[poisunk]
 *邮箱：1714480752@qq.com
 */
interface ItemTouchHelperAdapterCallback {

    fun onItemMove(fromPosition:Int,targetPosition: Int):Boolean
    fun onItemSwiped(position:Int)
}