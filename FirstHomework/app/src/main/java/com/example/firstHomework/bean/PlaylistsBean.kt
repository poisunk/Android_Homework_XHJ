package com.example.firstHomework.bean

/**
 *@author:created by $[poisunk]
 *邮箱：1714480752@qq.com
 */
data class PlaylistsBean(val isHasTaste:Boolean,
                         val code: Long,
                         val category: Long,
                         val result: List<Result>?)

data class Result (val id: Long,
                   val type:Long,
                   val name: String?,
                   val copywriter: String?,
                   val  picUrl: String?,
                   val isCanDislike:Boolean,
                   val trackNumberUpdateTime: Long,
                   val  playCount: Long,
                   val trackCount: Long,
                   val isHighQuality:Boolean,
                   val alg: String?)
