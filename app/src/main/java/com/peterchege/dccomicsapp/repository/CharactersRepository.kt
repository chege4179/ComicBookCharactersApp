/*
 * Copyright 2023 DC Comics App By Peter Chege
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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