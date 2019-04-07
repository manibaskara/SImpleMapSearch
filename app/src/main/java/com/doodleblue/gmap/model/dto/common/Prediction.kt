package com.doodleblue.gmap.model.dto.common

import com.squareup.moshi.Json

data class Prediction(
    @Json(name = "description")
    val description: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "matched_substrings")
    val matchedSubstrings: MutableList<MatchedSubstring>,
    @Json(name = "place_id")
    val placeId: String,
    @Json(name = "reference")
    val reference: String,
    @Json(name = "structured_formatting")
    val structuredFormatting: StructuredFormatting,
    @Json(name = "terms")
    val terms: MutableList<Term>,
    @Json(name = "types")
    val types: MutableList<String>
)