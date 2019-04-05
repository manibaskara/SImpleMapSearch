package com.doodleblue.gmap.model.webservice

import com.doodleblue.gmap.model.dto.LocationResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("json?")
    fun getAutoCompeteApi(
        @Query("input") inputText: String
        , @Query("key") apiKey: String
    ): Call<LocationResponseModel>

}