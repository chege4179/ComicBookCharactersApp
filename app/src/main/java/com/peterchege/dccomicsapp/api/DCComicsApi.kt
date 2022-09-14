package com.peterchege.dccomicsapp.api

import com.peterchege.dccomicsapp.api.responses.AllCharactersResponse
import com.peterchege.dccomicsapp.models.Character
import retrofit2.http.GET
import retrofit2.http.Path

interface DCComicsApi {

    @GET("all.json")
    suspend fun getAllCharacters():AllCharactersResponse

    @GET("id/{id}.json")
    suspend fun getCharacterById(@Path("id") id:String):Character
}