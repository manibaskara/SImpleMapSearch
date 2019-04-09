package com.doodleblue.gmap.model.webservice

import android.content.Context
import com.doodleblue.gmap.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient(private var mContext: Context) {

   @Volatile private var retrofitInstance : Retrofit?=null

    private fun getRetrofitInstance() : Retrofit{
        val instance = retrofitInstance
        if (instance!=null) {
            return instance
        }
        return synchronized(this){

            val retrofit = retrofitInstance
            if (retrofit!=null){
                retrofit
            } else{
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY   // set your desired log level

                val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
                httpClient.connectTimeout(2, TimeUnit.MINUTES)
                httpClient.readTimeout(2, TimeUnit.MINUTES)

                if (BuildConfig.DEBUG)
                    httpClient.addInterceptor(logging)
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