package com.doodleblue.gmap.model.webservice

import com.doodleblue.gmap.common.Constants
import com.doodleblue.gmap.model.dto.LocationResponseModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    @POST("json?")
    fun getAutoCompeteApi(
        @Field("input") inputText: String
        , @Field("key") apiKey: String = Constants.PlacesApi.PLACES_API_KEY
    ): Call<LocationResponseModel>

}