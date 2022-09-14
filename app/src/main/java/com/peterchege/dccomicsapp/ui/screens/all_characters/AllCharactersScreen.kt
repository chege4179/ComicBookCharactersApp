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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.peterchege.dccomicsapp.ui.components.CharacterCard
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
        modifier = Modifier.fillMaxSize(),
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
        Box(modifier = Modifier.fillMaxSize()) {
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
                    Modifier.background(MaterialTheme.colors.background)
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