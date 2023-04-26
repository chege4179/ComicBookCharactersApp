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

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.peterchege.dccomicsapp.ui.components.CharacterCard
import com.peterchege.dccomicsapp.ui.theme.GoogleBlackColor
import com.peterchege.dccomicsapp.util.Screens

@OptIn(ExperimentalCoilApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AllCharactersScreen(
    navController: NavController,
    viewModel:AllCharactersScreenViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize().background(GoogleBlackColor),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Comic Book Characters",
                    )
                },
                backgroundColor = MaterialTheme.colors.primary)
        }
    ) {
        Box(modifier = Modifier.fillMaxSize().background(GoogleBlackColor)) {
            if (viewModel.isLoading.value) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            if (viewModel.isError.value) {
                LaunchedEffect(scaffoldState.snackbarHostState) {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = viewModel.msg.value
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp)
                    .padding(top = 10.dp)
            ) {

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    Modifier.background(GoogleBlackColor)
                ) {
                    items(viewModel.characters.value) { character ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CharacterCard(
                                character = character,
                                onNavigateToSingleCharacterScreen = { id ->
                                    navController.navigate(Screens.SINGLE_CHARACTER_SCREEN + "/${id}")

                                },
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }

                }

            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }

}