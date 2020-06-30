package com.marvelapp.br.sdk.response.comic

import com.marvelapp.br.sdk.response.Thumbnail
import com.marvelapp.br.sdk.response.Url
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
    val characters: Characters,
    val description: String?,
    val id: Int,
    val images: List<Image>,
    val resourceURI: String,
    val thumbnail: Thumbnail,
    val name: String,
    val urls: List<Url>,
    val variantDescription: String,
    val variants: List<Variant>
)