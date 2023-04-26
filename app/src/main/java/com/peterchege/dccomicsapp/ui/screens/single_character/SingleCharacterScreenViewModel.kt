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
package com.peterchege.dccomicsapp.ui.screens.single_character

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peterchege.dccomicsapp.models.Character
import com.peterchege.dccomicsapp.repository.CharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class SingleCharacterScreenViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: CharactersRepository,
) :ViewModel(){


    private val _character = mutableStateOf<Character?>(null)
    val character : State<Character?> = _character

    private val _isLoading = mutableStateOf<Boolean>(false)
    val isLoading: State<Boolean> = _isLoading

    private val _isError = mutableStateOf<Boolean>(false)
    val isError: State<Boolean> = _isError

    private val _msg = mutableStateOf<String>("")
    val msg: State<String> = _msg

    private var _errorMsg = mutableStateOf("")
    var errorMsg: State<String> = _errorMsg
    init {
        savedStateHandle.get<String>("id")?.let {
            getSingleCharacter(characterId = it)
        }
    }
    private fun getSingleCharacter(characterId:String){
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val response = repository.getCharacterById(id = characterId)
                _isLoading.value = false
                _character.value = response
            }catch (e: HttpException){
                Log.e("HTTP ERROR",e.localizedMessage ?: "Http error")
                _isLoading.value = false
                _isError.value = true
                _errorMsg.value = e.localizedMessage?: "An unexpected error occurred"

            }catch (e: IOException){
                Log.e("IO ERROR",e.localizedMessage ?: "IO error")
                _isLoading.value = false
                _isError.value = true
                _errorMsg.value = e.localizedMessage?: "An unexpected error occurred"
            }

        }
    }


}