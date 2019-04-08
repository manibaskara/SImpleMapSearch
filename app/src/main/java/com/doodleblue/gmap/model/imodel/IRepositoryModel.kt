package com.doodleblue.gmap.model.imodel

import com.google.android.libraries.places.api.model.AutocompletePrediction

interface IRepositoryModel {
    fun isConnectedToInternet()

    fun returnData(prediction : MutableList<AutocompletePrediction>)
}