package com.doodleblue.gmap.view.iview

import androidx.fragment.app.FragmentActivity
import com.doodleblue.gmap.util.CodeSnippet
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.model.AutocompletePrediction

interface IView {

    fun showMessage(message: String)

    fun getActivity(): FragmentActivity?

    fun onPresenterCreated()

    val codeSnippet : CodeSnippet

    fun setMarkerOnMap(latLong : LatLng, place : AutocompletePrediction)

    fun hideKeyboard()
}