package com.doodleblue.gmap.view.iview

import com.doodleblue.gmap.adapter.listener.SearchResultListener
import com.google.android.libraries.places.api.model.AutocompletePrediction

interface ISearchLocationView : IView {

    fun showSearchResultBottomSheet(locationList: MutableList<AutocompletePrediction>, listener: SearchResultListener)

    fun showSelectedAddressBottomSheet()

    fun expandBottomSheet()

    fun collapseBottomsheet()

    fun resetSearchView()
}