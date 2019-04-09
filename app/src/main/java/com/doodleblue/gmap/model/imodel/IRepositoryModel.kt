package com.doodleblue.gmap.model.imodel

import com.google.android.libraries.places.api.model.AutocompletePrediction

interface IRepositoryModel {

    fun isConnectedToInternet() : Boolean

    fun returnData(prediction : MutableList<AutocompletePrediction>)

    fun showMessage(message : String)
}