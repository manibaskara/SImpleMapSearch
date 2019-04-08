package com.doodleblue.gmap.adapter.viewHolder

import com.doodleblue.gmap.adapter.listener.BaseRecyclerListener
import com.doodleblue.gmap.databinding.InflateLocationBinding
import com.doodleblue.gmap.model.dto.common.Prediction
import com.google.android.libraries.places.api.model.AutocompletePrediction

class SearchResultViewHolder(
    view: InflateLocationBinding,
    var listener: BaseRecyclerListener<AutocompletePrediction>
) : BaseViewHolder<AutocompletePrediction, InflateLocationBinding>(view) {

    override fun populateData(data: AutocompletePrediction) {
        viewDataBinding.locationData = data
        viewDataBinding.listener = listener
    }
}
/*

class SearchResultViewHolder(
    view: InflateLocationBinding,
    var listener: BaseRecyclerListener<Prediction>
) : BaseViewHolder<Prediction, InflateLocationBinding>(view) {

    override fun populateData(data: Prediction) {
        viewDataBinding.locationData = data
        viewDataBinding.listener = listener
    }
}
*/
