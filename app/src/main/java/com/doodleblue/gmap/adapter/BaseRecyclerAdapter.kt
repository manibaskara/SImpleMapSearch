package com.doodleblue.gmap.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.doodleblue.gmap.adapter.viewHolder.BaseViewHolder

abstract class BaseRecyclerAdapter<T, V: BaseViewHolder<T, * >>(var data: MutableList<T>?) : RecyclerView.Adapter<V>(){


    override fun getItemCount(): Int {
       return data!!.size
    }

    override fun onBindViewHolder(holder: V, position: Int) {
        holder.lastItemPosition = itemCount - 1
        holder.data = getItem(position)
    }

    @Throws(IndexOutOfBoundsException::class)
    fun getItem(position: Int): T {
        return data!![position]
    }

    fun inflateDataBinding(layout : Int, parent: ViewGroup) : ViewDataBinding? {
        return DataBindingUtil.bind(
            LayoutInflater.from(parent.context).inflate(layout, parent, false)
        )
    }
}