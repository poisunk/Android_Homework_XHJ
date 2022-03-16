package com.example.secondhomework.myThreadPool

/**
 *@author:created by $[poisunk]
 *邮箱：1714480752@qq.com
 */
interface MyRejectPolicy<T> {
    fun reject(myBlockQueue: MyBlockQueue<T>, task: T)
}