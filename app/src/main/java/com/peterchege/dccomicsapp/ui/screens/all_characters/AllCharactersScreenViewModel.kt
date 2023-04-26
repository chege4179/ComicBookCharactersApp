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
package com.peterchege.dccomicsapp.ui.screens.all_characters

import android.util.Log
import android.view.View
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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
class AllCharactersScreenViewModel @Inject constructor(
    private val repository: CharactersRepository,

) :ViewModel(){
    private var _characters = mutableStateOf<List<Character>>(emptyList())
    var characters : State<List<Character>> = _characters

    private var _isLoading = mutableStateOf(false)
    var isLoading: State<Boolean> = _isLoading

    private var _isError = mutableStateOf(false)
    var isError: State<Boolean> = _isError

    private var _msg = mutableStateOf("")
    var msg: State<String> = _msg

    private var _errorMsg = mutableStateOf("")
    var errorMsg: State<String> = _errorMsg

    init {
        getCharacters()
    }

    private fun getCharacters(){
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val response = repository.getCharacters()
                _isLoading.value = false
                _characters.value = response
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