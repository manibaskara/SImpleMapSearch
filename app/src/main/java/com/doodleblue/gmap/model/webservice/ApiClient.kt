package com.doodleblue.gmap.model.webservice

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient(private var mContext: Context) {

   @Volatile private var retrofitInstance : Retrofit?=null

    fun getRetrofitInstance() : Retrofit{
        val instance = retrofitInstance
        if (instance!=null) {
            return instance
        }
        return synchronized(this){

            val instance_two = retrofitInstance
            if (instance_two!=null){
                instance_two
            } else{
                val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
                httpClient.connectTimeout(2, TimeUnit.MINUTES)
                httpClient.readTimeout(2, TimeUnit.MINUTES)
                return Retrofit.Builder()
                    .baseUrl("https://maps.googleapis.com/maps/api/place/autocomplete/")
                    .client(httpClient.build())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
            }
        }
    }

    fun getApiInterface(): ApiInterface = getRetrofitInstance().create(ApiInterface::class.java)
}