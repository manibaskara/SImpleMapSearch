package com.doodleblue.gmap.model.webservice

import com.doodleblue.gmap.common.Constants
import com.doodleblue.gmap.model.dto.response.AutoCompleteResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("json?")
    fun getAutoCompeteApi(
        @Query("input") inputText: String
        , @Query("key") apiKey: String = Constants.PlacesApi.PLACES_API_KEY
    ): Call<AutoCompleteResponse>

}