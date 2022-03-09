package com.example.firstHomework.networkService

import com.example.firstHomework.bean.PlaylistsBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *@author:created by $[poisunk]
 *邮箱：1714480752@qq.com
 */
interface NetworkService {

    @GET("personalized")
    fun getPlaylists(@Query("limit") limit:Int): Call<PlaylistsBean>

}