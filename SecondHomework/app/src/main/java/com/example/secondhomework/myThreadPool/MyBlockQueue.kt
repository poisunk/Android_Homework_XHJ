package com.example.secondhomework.myThreadPool

import java.util.*
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.ReentrantLock

/**
 *@author:created by $[poisunk]
 *邮箱：1714480752@qq.com
 */
class MyBlockQueue<T>(val size:Int) {

    private val lock:ReentrantLock= ReentrantLock()

    private val queue:Deque<T> = ArrayDeque()

    private val fullwaitset:Condition = lock.newCondition()

    private val emptywaitset:Condition = lock.newCondition()


    fun tack():T{
        lock.lock()
        try {
            while(queue.isEmpty()){
                try {
                    emptywaitset.await()
                }catch (e:InterruptedException){
                    e.printStackTrace()
                }
            }
            val element:T=queue.removeFirst()
            fullwaitset.signal()
            return element
        }finally {
            lock.unlock()
        }
    }

    fun put(element:T){
        lock.lock()
        try {
            while(queue.size >= size){
                try {
                    fullwaitset.await()
                }catch (e:InterruptedException){
                    e.printStackTrace()
                }
            }
            queue.addLast(element)
            emptywaitset.signal()
        }finally {
            lock.unlock()
        }
    }

    fun tryPut(rejectPolicy: MyRejectPolicy<T>, task: T){
        lock.lock()
        try{
            if(queue.size>= size){
                rejectPolicy.reject(this,task)
            }else {
                queue.addLast(task)
                emptywaitset.signal()
            }
        }finally {
            lock.unlock()
        }
    }
}