package com.example.firstHomework.page.playlist.model

import androidx.lifecycle.liveData
import com.example.firstHomework.networkService.PlaylistsNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.lang.RuntimeException

/**
 *@author:created by $[poisunk]
 *邮箱：1714480752@qq.com
 */
object Repository {

    fun searchPlaylists(limit:Int)=liveData(Dispatchers.IO){
        val result=try {
            val playlistsBean = PlaylistsNetwork.searchPlaylists(limit)
            if(playlistsBean.result!=null){
                val results=playlistsBean.result
                Result.success(results)
            }else{
                Result.failure(RuntimeException())
            }
        }catch (e:Exception){
            Result.failure<List<com.example.firstHomework.bean.Result>>(e)
        }
        emit(result)
    }

}