package com.doodleblue.gmap.model

import android.content.Context
import com.doodleblue.gmap.common.Constants
import com.doodleblue.gmap.model.dto.LocationResponseModel
import com.doodleblue.gmap.model.dto.response.BaseResponse
import com.doodleblue.gmap.model.imodel.IRepositoryModel
import com.doodleblue.gmap.model.webservice.ApiClient
import com.doodleblue.library.CustomException
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModelRepository(var context: Context, iRepositoryModel: IRepositoryModel) {

    var apiClient = ApiClient(context)

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

    fun getAutoCompleteData(inputText : String):Observable<LocationResponseModel> =
        enqueue(apiClient.getApiInterface().getAutoCompeteApi(inputText))
}