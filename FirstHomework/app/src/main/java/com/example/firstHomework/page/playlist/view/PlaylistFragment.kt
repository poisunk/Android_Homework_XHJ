package com.example.firstHomework.page.playlist.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstHomework.R
import com.example.firstHomework.page.playlist.adapter.PlaylistsAdapter
import com.example.firstHomework.page.playlist.viewModel.PlaylistsViewModel
import kotlinx.android.synthetic.main.fragment_recommend_playlist.*

/**
 *@author:created by $[poisunk]
 *邮箱：1714480752@qq.com
 */
class PlaylistFragment:Fragment() {

    private val viewModel by lazy { ViewModelProviders.of(this).get(PlaylistsViewModel::class.java) }

    private lateinit var adapter: PlaylistsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_recommend_playlist,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onResume() {
        super.onResume()
        viewModel.searchPlaylists(30)
    }


    @SuppressLint("FragmentLiveDataObserve")
    private fun init(){
        val layoutManager=GridLayoutManager(requireContext(),3)
        recyclerView.layoutManager=layoutManager
        adapter=PlaylistsAdapter(this,viewModel.playlists)
        recyclerView.adapter=adapter
        viewModel.playlistsLiveData.observe(this, Observer {
            val playlists=it.getOrNull()
            if(playlists!=null){
                viewModel.playlists.clear()
                viewModel.playlists.addAll(playlists)
                adapter.notifyDataSetChanged()
            }else{
                it.exceptionOrNull()?.printStackTrace()
            }
        })


        button_back.setOnClickListener(View.OnClickListener {
            val fragmentManager=requireActivity().supportFragmentManager
            fragmentManager.popBackStack()
        })
    }
}