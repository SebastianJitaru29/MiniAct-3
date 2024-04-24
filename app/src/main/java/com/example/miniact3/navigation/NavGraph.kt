package com.example.miniact3.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.miniact3.models.ImageScreenUiState
import com.example.miniact3.models.TextScreenUiState
import com.example.miniact3.models.TextScreenViewModel
import com.example.miniact3.ui.theme.screens.ImageScreen
import com.example.miniact3.ui.theme.screens.TextScreen

@Composable
fun SetUpNavGraph(
    navController: NavHostController,
    textScreenUiState: TextScreenUiState,
    imageScreenUiState: ImageScreenUiState
){
    NavHost(
        navController = navController,
        startDestination = Screen.TextScreen.route
    ){
        composable(
            route = Screen.TextScreen.route
        ){
            val modifier = Modifier.fillMaxSize()
            TextScreen(textScreenUiState = textScreenUiState,modifier)
        }
        composable(
            route = Screen.ImageScreen.route
        ){
            val modifier = Modifier.fillMaxSize()
            ImageScreen(modifier)
        }
    }
}