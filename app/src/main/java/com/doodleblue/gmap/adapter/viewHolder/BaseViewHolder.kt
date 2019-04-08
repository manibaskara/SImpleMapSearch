package com.doodleblue.gmap.adapter.viewHolder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T, VB : ViewDataBinding> : RecyclerView.ViewHolder {

    protected lateinit var viewDataBinding: VB

    var data: T? = null
        set(value) {
            field = value
            data?.let { populateData(it) }
        }

    internal constructor(viewDataBinding: VB) : super(viewDataBinding.root) {
        this.viewDataBinding = viewDataBinding
    }

    internal abstract fun populateData(data: T)

}