package com.marvelapp.br.sdk.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
    val comics: Comics,
    val description: String,
    val id: Int,
    val name: String,
    val resourceURI: String,
    val thumbnail: Thumbnail,
    val urls: List<Url>
)