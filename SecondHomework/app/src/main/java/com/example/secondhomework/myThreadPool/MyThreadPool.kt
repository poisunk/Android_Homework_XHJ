package com.example.secondhomework.myThreadPool

import java.util.ArrayList
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.locks.ReentrantLock

/**
 *@author:created by $[poisunk]
 *邮箱：1714480752@qq.com
 */
class MyThreadPool(val coreSize:Int,val queueSize:Int,
                  val rejectPolicy: MyRejectPolicy<Runnable>){

    private val queue:MyBlockQueue<Runnable> = MyBlockQueue(queueSize)

    private val lock:ReentrantLock= ReentrantLock()

    private var workers:MutableList<Worker> = ArrayList()

    fun executeTask(task:Runnable){
        lock.lock()
        try {
            if(workers.size<coreSize){
                val worker=Worker(task)
                workers.add(worker)
                worker.start()
            }else{
                queue.tryPut(rejectPolicy,task)
            }
        }finally {
            lock.unlock()
        }
    }


    inner class Worker(var task:Runnable?):Thread(){

        override fun run(){
            while (task != null){
                try {
                    task!!.run()
                }finally {
                    task=queue.tack()
                }
            }

            synchronized(this){
                workers.remove(this)
            }
        }


    }


}
