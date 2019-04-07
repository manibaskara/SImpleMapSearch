package com.doodleblue.gmap.model.dto.response

import com.doodleblue.gmap.model.dto.common.Prediction
import com.squareup.moshi.Json

data class AutoCompleteResponse(
    @Json(name = "predictions")
    val predictions: MutableList<Prediction>,
    @Json(name = "status")
    val status: String
) : BaseResponse()