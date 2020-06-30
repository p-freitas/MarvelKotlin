package com.marvelapp.br.sdk

import com.marvelapp.br.sdk.response.PersonagensResponse
import com.marvelapp.br.sdk.response.comic.ComicDetalheResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface API {
    @GET("v1/public/characters?ts=1&orderBy=name&limit=10&apikey=7fa31e8e2e8a14ebf2e45c606023d57e&hash=70e086764ee39ba8e7bbffb5aadb801e")
    fun getPersonagens(@Query("offset") offset: Int = 0) : Deferred<Response<PersonagensResponse>>

    @GET("v1/public/characters/{id}?ts=1&&apikey=7fa31e8e2e8a14ebf2e45c606023d57e&hash=70e086764ee39ba8e7bbffb5aadb801e")
    fun getPersonagem(
        @Path("id") id: Int
    ) : Deferred<ComicDetalheResponse>
}