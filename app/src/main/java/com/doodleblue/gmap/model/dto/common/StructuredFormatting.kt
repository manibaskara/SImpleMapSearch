package com.doodleblue.gmap.model.dto.common

import com.squareup.moshi.Json

data class StructuredFormatting(
    @Json(name = "main_text")
    val mainText: String,
    @Json(name = "main_text_matched_substrings")
    val mainTextMatchedSubstrings: MutableList<MainTextMatchedSubstring>,
    @Json(name = "secondary_text")
    val secondaryText: String
)