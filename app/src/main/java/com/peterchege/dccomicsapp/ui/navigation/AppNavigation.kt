package com.peterchege.dccomicsapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.peterchege.dccomicsapp.ui.screens.all_characters.AllCharactersScreen
import com.peterchege.dccomicsapp.ui.screens.single_character.SingleCharacterScreen
import com.peterchege.dccomicsapp.util.Screens

@ExperimentalPagerApi
@ExperimentalComposeUiApi
@Composable
fun AppNavigation(
    navController: NavHostController
){
    NavHost(
        navController =navController,
        startDestination = Screens.ALL_CHARACTER_SCREENS,
    ){
        composable(Screens.ALL_CHARACTER_SCREENS){
            AllCharactersScreen(navController = navController)
        }
        composable(Screens.SINGLE_CHARACTER_SCREEN + "/{id}"){
            SingleCharacterScreen(navController = navController)
        }


    }
}