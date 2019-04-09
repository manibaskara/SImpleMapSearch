package com.doodleblue.gmap.adapter

import android.view.ViewGroup
import com.doodleblue.gmap.R
import com.doodleblue.gmap.adapter.listener.BaseRecyclerListener
import com.doodleblue.gmap.adapter.viewHolder.SearchResultViewHolder
import com.doodleblue.gmap.databinding.InflateLocationBinding
import com.google.android.libraries.places.api.model.AutocompletePrediction

/*class SearchResultAdapter(
    data: MutableList<Prediction>?,
    var listener: BaseRecyclerListener<Prediction>
) : BaseRecyclerAdapter<Prediction, SearchResultViewHolder>(data) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        return SearchResultViewHolder(
            inflateDataBinding(R.layout.inflate_location, parent) as InflateLocationBinding,
            listener
        )
    }

}*/
class SearchResultAdapter(
    data: MutableList<AutocompletePrediction>?,
    var listener: BaseRecyclerListener<AutocompletePrediction>
) : BaseRecyclerAdapter<AutocompletePrediction, SearchResultViewHolder>(data) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        return SearchResultViewHolder(
            inflateDataBinding(R.layout.inflate_location, parent) as InflateLocationBinding,
            listener
        )
    }

}
