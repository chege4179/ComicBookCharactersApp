package com.peterchege.dccomicsapp.ui.screens.single_character

import android.annotation.SuppressLint
import android.util.Half.toFloat
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.peterchege.dccomicsapp.ui.theme.DcBlueColor
import com.peterchege.dccomicsapp.ui.theme.GoogleBlackColor

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
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(GoogleBlackColor),

                    ) {
                    item{
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
                    }
                    item{
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 10.dp)

                        ) {
                            Text(
                                color = DcBlueColor,
                                text = character.name,
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Start
                            )
                            Text(
                                text = character.biography.fullName,
                                color = DcBlueColor,
                                fontSize = 20.sp,
                                fontWeight  = FontWeight.Bold,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Start
                            )
                            Text(
                                color = DcBlueColor,
                                text = character.appearance.race,
                                fontSize = 20.sp,
                                fontWeight  = FontWeight.Bold,
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
                                    Text(
                                        color = DcBlueColor,
                                        text = "Intelligence")

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
                                    Text(
                                        color = DcBlueColor,
                                        text = "Strength"
                                    )
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
                                    Text(
                                        color = DcBlueColor,
                                        text = "Speed"
                                    )
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
                                    Text(
                                        color = DcBlueColor,
                                        text = "Durability")
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
                                    Text(
                                        color = DcBlueColor,
                                        text = "Power"
                                    )
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
                                    Text(
                                        color = DcBlueColor,
                                        text = "Combat"
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}