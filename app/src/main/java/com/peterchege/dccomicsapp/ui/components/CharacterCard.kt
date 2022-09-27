package com.peterchege.dccomicsapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.SubcomposeAsyncImage
import coil.compose.rememberImagePainter
import com.peterchege.dccomicsapp.models.Character
import com.peterchege.dccomicsapp.ui.theme.DcBlueColor
import com.peterchege.dccomicsapp.ui.theme.GoogleBlackColor


@ExperimentalCoilApi
@Composable
fun CharacterCard(
    character: Character,
    onNavigateToSingleCharacterScreen:(String) -> Unit,

) {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .background(GoogleBlackColor)
            .clickable {
                onNavigateToSingleCharacterScreen(character.id.toString())
            }
        ,
        ) {
        Column(
            modifier = Modifier.fillMaxWidth().background(GoogleBlackColor),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
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
                    .fillMaxSize()
                    .height(150.dp),
                contentDescription = "Character Image"
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,

                ) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.85f),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        color = DcBlueColor,
                        text = character.name,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}