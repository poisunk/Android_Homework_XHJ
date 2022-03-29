package com.example.thirdhomework.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *@author:created by $[poisunk]
 *邮箱：1714480752@qq.com
 */
object ServiceCreator {

    private const val BASE_URL="https://netease-cloud-music-api-omega-silk.vercel.app/"

    private val retrofit=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass:Class<T>):T= retrofit.create(serviceClass)

    inline fun <reified T> create():T= create(T::class.java)

}