package com.peterchege.dccomicsapp.repository

import com.peterchege.dccomicsapp.api.DCComicsApi
import com.peterchege.dccomicsapp.api.responses.AllCharactersResponse
import com.peterchege.dccomicsapp.models.Character
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val api: DCComicsApi
) {
    suspend fun getCharacters():AllCharactersResponse{
        return api.getAllCharacters()
    }

    suspend fun getCharacterById(id:String):Character{
        return api.getCharacterById(id = id)
    }

}