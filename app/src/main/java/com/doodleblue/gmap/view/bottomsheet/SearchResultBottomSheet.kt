package com.doodleblue.gmap.view.bottomsheet

import android.content.Context
import com.doodleblue.gmap.R
import com.doodleblue.gmap.adapter.SearchResultAdapter
import com.doodleblue.gmap.adapter.listener.SearchResultListener
import com.doodleblue.gmap.databinding.SearchResultBottomsheetBinding
import com.google.android.libraries.places.api.model.AutocompletePrediction

class SearchResultBottomSheet(context: Context/*, var iSearchResultListener: SearchResultListener*/) : BaseBottomSheetDialog<SearchResultBottomsheetBinding>(context) {

    override fun getLayoutId(): Int {
        return R.layout.search_result_bottomsheet
    }

    override fun bindDataToView(data: Any) {
        val predictionList = (data as? MutableList<*>)?.filterIsInstance<AutocompletePrediction>()
        if (predictionList is MutableList<AutocompletePrediction> && predictionList.isNotEmpty()) {
            bViewDataBinding?.rvSearchResult?.adapter = SearchResultAdapter(predictionList,  context as SearchResultListener)
        }
    }
}