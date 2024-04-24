package com.example.miniact3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.miniact3.models.ImageScreenViewModel
import com.example.miniact3.models.TextScreenViewModel
import com.example.miniact3.navigation.Screen
import com.example.miniact3.navigation.SetUpNavGraph
import com.example.miniact3.ui.theme.MiniAct3Theme

import com.example.miniact3.ui.theme.screens.ImageScreen
import com.example.miniact3.ui.theme.screens.TextScreen

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiniAct3Theme {
                navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(navController)
                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController){
    val textScreenViewModel: TextScreenViewModel = viewModel()
    val imageScreenViewModel : ImageScreenViewModel = viewModel()

    SetUpNavGraph(navController = navController, textScreenUiState = textScreenViewModel.textScreenUiState, imageScreenUiState = imageScreenViewModel.imageScreenUiState)
    Row {
        Button(onClick = { navController.navigate(route = Screen.ImageScreen.route) }, colors = ButtonColors(
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.inversePrimary,
            MaterialTheme.colorScheme.secondary,
            MaterialTheme.colorScheme.primaryContainer

        )) {
            Text(text = "ImageScreen")
        }
        Spacer(modifier = Modifier.size(120.dp))
        Button(onClick = { navController.popBackStack() }, colors = ButtonColors(
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.inversePrimary,
            MaterialTheme.colorScheme.secondary,
            MaterialTheme.colorScheme.primaryContainer

        )) {
            Text(text = "TextScreen")
        }
    }
    /*
    Column {
        TextScreen(textScreenUiState = textScreenViewModel.textScreenUiState, modifier = Modifier.weight(1f))
        ImageScreen(modifier = Modifier.weight(1f))
    }*/
}

