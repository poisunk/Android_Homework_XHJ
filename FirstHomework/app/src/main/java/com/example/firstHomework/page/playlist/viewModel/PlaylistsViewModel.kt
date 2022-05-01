package com.example.firstHomework.page.playlist.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.firstHomework.bean.Result
import com.example.firstHomework.page.playlist.model.Repository

/**
 *@author:created by $[poisunk]
 *邮箱：1714480752@qq.com
 */
class PlaylistsViewModel:ViewModel() {

    private val searchLiveData=MutableLiveData<Int>()

    val playlists=ArrayList<Result>()

    val playlistsLiveData=Transformations
        .switchMap(searchLiveData){
            Repository.searchPlaylists(it)
        }

    fun searchPlaylists(limit:Int){
        searchLiveData.value = limit
    }

}