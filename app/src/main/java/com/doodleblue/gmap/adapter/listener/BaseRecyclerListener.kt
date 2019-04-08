package com.doodleblue.gmap.adapter.listener

interface BaseRecyclerListener<T>{

    fun onItemClick(position: Int, data: T)
}