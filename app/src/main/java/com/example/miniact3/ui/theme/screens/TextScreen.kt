package com.example.miniact3.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.miniact3.R
import com.example.miniact3.models.TextScreenUiState
import com.example.miniact3.ui.theme.MiniAct3Theme

@Composable
fun TextScreen(
    textScreenUiState: TextScreenUiState,
    modifier: Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
){
    when(textScreenUiState) {
        is TextScreenUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is TextScreenUiState.Success -> ResultScreen(
            textScreenUiState.photos,
            modifier= modifier.fillMaxWidth()
        )
        is TextScreenUiState.Error ->ErrorScreen(modifier = modifier.fillMaxSize())
        else ->  {}
    }
}
@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading)
    )
}

/**
 * The home screen displaying error message with re-attempt button.
 */
@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
        )
        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp))
    }
}

/**
 * ResultScreen displaying number of photos retrieved.
 */
@Composable
private fun ResultScreen(photos: String, modifier: Modifier = Modifier) {
    val state = rememberScrollState()

    Column(
        modifier = Modifier
            .size(100.dp)
            .padding(horizontal = 8.dp)
            .verticalScroll(state)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier

        ) {
            Text(text = photos)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview() {
    MiniAct3Theme {
        LoadingScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview() {
    MiniAct3Theme {
        ErrorScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun PhotosGridScreenPreview() {
    MiniAct3Theme {
        ResultScreen(stringResource(R.string.succes))
    }
}