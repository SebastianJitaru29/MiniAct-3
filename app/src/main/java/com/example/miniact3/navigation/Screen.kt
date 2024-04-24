package com.example.miniact3.navigation

sealed class Screen (val route: String) {
    object TextScreen: Screen(route = "text_screen")
    object ImageScreen: Screen(route = "image_screen")
}