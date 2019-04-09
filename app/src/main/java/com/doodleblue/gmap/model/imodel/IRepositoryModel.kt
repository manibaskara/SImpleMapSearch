package com.doodleblue.gmap.model.imodel

import com.doodleblue.gmap.adapter.listener.BaseRecyclerListener
import com.doodleblue.gmap.adapter.listener.SearchResultListener
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.model.AutocompletePrediction

interface IRepositoryModel {

    fun isConnectedToInternet() : Boolean

    fun returnData(prediction : MutableList<AutocompletePrediction>)

    fun showMessage(message : String)
}