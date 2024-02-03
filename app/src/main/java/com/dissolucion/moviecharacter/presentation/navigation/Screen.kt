package com.dissolucion.moviecharacter.presentation.navigation

sealed class Screen(val route: String) {
    data object CharacterScreen: Screen("character_screen")
}