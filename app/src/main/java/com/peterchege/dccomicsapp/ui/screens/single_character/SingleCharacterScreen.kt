package com.peterchege.dccomicsapp.ui.screens.single_character

import android.annotation.SuppressLint
import android.util.Half.toFloat
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import com.peterchege.dccomicsapp.ui.components.CircularProgressBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SingleCharacterScreen(
    navController: NavController,
    viewModel: SingleCharacterScreenViewModel= hiltViewModel()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        if (viewModel.isLoading.value) {
            Box(modifier = Modifier.fillMaxSize()){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

        }else{
            viewModel.character.value?.let { character ->
                Column(
                    modifier = Modifier.fillMaxSize(),

                    ) {
                    SubcomposeAsyncImage(
                        model = character.images.lg,
                        loading = {
                            Box(modifier = Modifier.fillMaxSize()) {
                                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                            }
                        },
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp),
                        contentDescription = "Post Image"
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 10.dp)

                    ) {
                        Text(
                            text = character.name,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Start

                        )

                        Text(
                            text = "Full Name : " +character.biography.fullName,
                            fontSize = 20.sp,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Start
                        )
                        Text(
                            text = "Race : " +character.appearance.race,
                            fontSize = 20.sp,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Start
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ){
                            Column(
                                modifier = Modifier.height(100.dp),
                                verticalArrangement = Arrangement.SpaceEvenly,
                                horizontalAlignment = Alignment.CenterHorizontally,

                            ) {
                                CircularProgressBar(
                                    percentage = character.powerstats.intelligence.toFloat() / 100,
                                    number = character.powerstats.intelligence
                                )
                                Text(text = "Intelligence")
                            }
                            Column(
                                modifier = Modifier.height(100.dp),
                                verticalArrangement = Arrangement.SpaceEvenly,
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                CircularProgressBar(
                                    percentage = character.powerstats.strength.toFloat() / 100,
                                    number = character.powerstats.strength
                                )
                                Text(text = "Strength")
                            }
                            Column(
                                modifier = Modifier.height(100.dp),
                                verticalArrangement = Arrangement.SpaceEvenly,
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                CircularProgressBar(
                                    percentage = character.powerstats.speed.toFloat() / 100,
                                    number = character.powerstats.speed
                                )
                                Text(text = "Speed")
                            }


                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ){
                            Column(
                                modifier = Modifier.height(100.dp),
                                verticalArrangement = Arrangement.SpaceEvenly,
                                horizontalAlignment = Alignment.CenterHorizontally,

                                ) {
                                CircularProgressBar(
                                    percentage = character.powerstats.durability.toFloat() / 100,
                                    number = character.powerstats.durability
                                )
                                Text(text = "Durability")
                            }
                            Column(
                                modifier = Modifier.height(100.dp),
                                verticalArrangement = Arrangement.SpaceEvenly,
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                CircularProgressBar(
                                    percentage = character.powerstats.power.toFloat() / 100,
                                    number = character.powerstats.power
                                )
                                Text(text = "Power")
                            }
                            Column(
                                modifier = Modifier.height(100.dp),
                                verticalArrangement = Arrangement.SpaceEvenly,
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                CircularProgressBar(
                                    percentage = character.powerstats.combat.toFloat() / 100,
                                    number = character.powerstats.combat
                                )
                                Text(text = "Combat")
                            }


                        }
                    }

                }


            }
        }



    }




}