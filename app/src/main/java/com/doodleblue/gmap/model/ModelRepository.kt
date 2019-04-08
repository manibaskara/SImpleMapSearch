package com.doodleblue.gmap.model

import android.content.Context
import com.doodleblue.gmap.common.Constants
import com.doodleblue.gmap.model.dto.response.AutoCompleteResponse
import com.doodleblue.gmap.model.dto.response.BaseResponse
import com.doodleblue.gmap.model.imodel.IRepositoryModel
import com.doodleblue.gmap.model.webservice.ApiClient
import com.doodleblue.library.CustomException
import com.google.android.gms.common.api.ApiException
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.AutocompletePrediction
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.model.TypeFilter
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.libraries.places.api.net.PlacesClient
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModelRepository(var context: Context, private var iRepositoryModel: IRepositoryModel) {

    var apiClient = ApiClient(context)

    var placesClient: PlacesClient

    init {

        Places.initialize(context, Constants.PlacesApi.PLACES_API_KEY)

        placesClient = Places.createClient(context)
    }

    private fun <T : BaseResponse> enqueue(callback: Call<T>): Observable<T> {

        return Observable.create<T> {
            callback.enqueue(object : Callback<T> {

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    if (response.body() != null && response.code() == 200) {
                        val result = response.body()
                        result?.let { it1 -> it.onNext(it1) }
                    } else {
                        it.onError(CustomException(response.code(), Constants.HttpErrorMessage.INTERNAL_SERVER_ERROR))
                    }
                }

                override fun onFailure(call: Call<T>, t: Throwable) {

                    try {
                        t.let { it1 -> it.onError(CustomException(500, t.localizedMessage)) }
                    } catch (e: Exception) {

                    }
                }
            })
        }
    }


    fun getAutoCompleteDataModel(query: String) {

        val token = AutocompleteSessionToken.newInstance()
        val request = FindAutocompletePredictionsRequest.builder()
            .setTypeFilter(TypeFilter.ADDRESS)
            .setSessionToken(token)
            .setQuery(query)
            .build()

        placesClient.findAutocompletePredictions(request).addOnSuccessListener { response ->
            for (prediction in response.getAutocompletePredictions()) {
                val dataResponse: MutableList<AutocompletePrediction> = response.autocompletePredictions
                iRepositoryModel.returnData(dataResponse)

            }
        }.addOnFailureListener({ exception ->
            if (exception is ApiException) {
                val apiException = exception as ApiException
                //Toast.makeText(applicationContext, apiException.toString(), Toast.LENGTH_SHORT).show()
            }
        })
    }


    fun getAutoCompleteData(inputText: String): Observable<AutoCompleteResponse> =
        enqueue(apiClient.getApiInterface().getAutoCompeteApi(inputText))
}