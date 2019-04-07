package com.doodleblue.gmap.model.dto.common

import com.squareup.moshi.Json

data class MatchedSubstring(
    @Json(name = "length")
    val length: Int,
    @Json(name = "offset")
    val offset: Int
)