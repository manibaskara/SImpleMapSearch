package com.doodleblue.gmap.common

import android.util.Log
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.model.RectangularBounds
import com.google.android.libraries.places.api.model.TypeFilter
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.PlacesClient
import android.R.attr.apiKey
import android.content.Context
import com.google.android.libraries.places.api.model.AutocompletePrediction


class CodeSnippet(val context: Context) {

    fun getAutoCompleteData(query: String) {

        // Initialize Places.
        Places.initialize(context, Constants.PlacesApi.PLACES_API_KEY)

// Create a new Places client instance.
        val placesClient = Places.createClient(context)

        // Create a new token for the autocomplete session. Pass this to FindAutocompletePredictionsRequest,
        // and once again when the user makes a selection (for example when calling fetchPlace()).
        val token = AutocompleteSessionToken.newInstance()

        // Create a RectangularBounds object.
        val bounds = RectangularBounds.newInstance(
            LatLng(-33.880490, 151.184363),
            LatLng(-33.858754, 151.229596)
        )
        // Use the builder to create a FindAutocompletePredictionsRequest.
        val request = FindAutocompletePredictionsRequest.builder()
            // Call either setLocationBias() OR setLocationRestriction().
            //.setLocationBias(bounds)
            //.setLocationRestriction(bounds)
            .setCountry("IN")
            .setTypeFilter(TypeFilter.ADDRESS)
            .setSessionToken(token)
            .setQuery(query)
            .build()

        placesClient.findAutocompletePredictions(request).addOnSuccessListener({ response ->
            for (prediction in response.getAutocompletePredictions()) {
              val dataResponse : MutableList<AutocompletePrediction> = response.autocompletePredictions
//                Log.i(TAG, prediction.getPlaceId())
//                Log.i(TAG, prediction.getPrimaryText(null).toString())
            }
        }).addOnFailureListener({ exception ->
            if (exception is ApiException) {
                val apiException = exception as ApiException
            }
        })
    }
}