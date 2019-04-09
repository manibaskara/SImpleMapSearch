package com.doodleblue.gmap.adapter.viewHolder

import android.graphics.Typeface
import android.text.style.StyleSpan
import com.doodleblue.gmap.adapter.listener.BaseRecyclerListener
import com.doodleblue.gmap.databinding.InflateLocationBinding
import com.google.android.libraries.places.api.model.AutocompletePrediction

class SearchResultViewHolder(
    view: InflateLocationBinding,
    var listener: BaseRecyclerListener<AutocompletePrediction>
) : BaseViewHolder<AutocompletePrediction, InflateLocationBinding>(view) {

    override fun populateData(data: AutocompletePrediction) {
        viewDataBinding.locationData = data
        viewDataBinding.listener = listener
        viewDataBinding.tvPlace.text = data.getFullText(StyleSpan(Typeface.BOLD))
    }
}