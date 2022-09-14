package com.peterchege.dccomicsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.peterchege.dccomicsapp.ui.navigation.AppNavigation
import com.peterchege.dccomicsapp.ui.theme.DCComicsAppTheme
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class, ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DCComicsAppTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                AppNavigation(navController = navController)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DCComicsAppTheme {
        Greeting("Android")
    }
}