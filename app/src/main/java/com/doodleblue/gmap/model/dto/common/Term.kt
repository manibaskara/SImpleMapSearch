package com.doodleblue.gmap.model.dto.common

import com.squareup.moshi.Json

data class Term(
    @Json(name = "offset")
    val offset: Int,
    @Json(name = "value")
    val value: String
)