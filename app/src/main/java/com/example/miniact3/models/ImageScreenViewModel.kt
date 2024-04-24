package com.example.miniact3.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.miniact3.network.ImageApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface ImageScreenUiState{
    data class Success(val photos: String) : ImageScreenUiState
    object Error : ImageScreenUiState
    object Loading : ImageScreenUiState
}

class ImageScreenViewModel : ViewModel(){
    var imageScreenUiState: ImageScreenUiState by mutableStateOf(ImageScreenUiState.Loading)
        private set
    //call getmarsphotos in init so status is displayed immediatlyz
    init {
        getMarsPhotos()
    }

    fun getMarsPhotos(){
        viewModelScope.launch {
            imageScreenUiState = ImageScreenUiState.Loading
            imageScreenUiState = try {
                val listResult = ImageApi.retrofitService.getPhotos()
                ImageScreenUiState.Success(
                    listResult
                )
            } catch (e: IOException) {
                ImageScreenUiState.Error
            } catch (e: HttpException) {
                ImageScreenUiState.Error
            }
        }
    }
}