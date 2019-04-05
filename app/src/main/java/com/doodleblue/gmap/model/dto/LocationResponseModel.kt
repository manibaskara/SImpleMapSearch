package com.doodleblue.gmap.model.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocationResponseModel(
    @field:Json(name = "predictions")
    var predictions: MutableList<Prediction>,
    @field:Json(name = "status")
    var status: String
) {
    @JsonClass(generateAdapter = true)
    data class Prediction(
        @field:Json(name = "description")
        var description: String,
        @field:Json(name = "id")
        var id: String,
        @field:Json(name = "matched_substrings")
        var matchedSubstrings: MutableList<MatchedSubstring>,
        @field:Json(name = "place_id")
        var placeId: String,
        @field:Json(name = "reference")
        var reference: String,
        @field:Json(name = "structured_formatting")
        var structuredFormatting: StructuredFormatting,
        @field:Json(name = "terms")
        var terms: MutableList<Term>,
        @field:Json(name = "types")
        var types: MutableList<String>
    ) {
        @JsonClass(generateAdapter = true)
        data class Term(
            @field:Json(name = "offset")
            var offset: Int,
            @field:Json(name = "varue")
            var varue: String
        )

        @JsonClass(generateAdapter = true)
        data class StructuredFormatting(
            @field:Json(name = "main_text")
            var mainText: String,
            @field:Json(name = "main_text_matched_substrings")
            var mainTextMatchedSubstrings: MutableList<MainTextMatchedSubstring>,
            @field:Json(name = "secondary_text")
            var secondaryText: String
        ) {
            @JsonClass(generateAdapter = true)
            data class MainTextMatchedSubstring(
                @field:Json(name = "length")
                var length: Int,
                @field:Json(name = "offset")
                var offset: Int
            )
        }

        @JsonClass(generateAdapter = true)
        data class MatchedSubstring(
            @field:Json(name = "length")
            var length: Int,
            @field:Json(name = "offset")
            var offset: Int
        )
    }
}