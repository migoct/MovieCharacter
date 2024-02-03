package com.dissolucion.moviecharacter.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dissolucion.moviecharacter.presentation.components.CharacterScreen
import com.dissolucion.moviecharacter.presentation.viewmodel.CharactersViewModel

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.CharacterScreen.route) {
        composable(Screen.CharacterScreen.route) {
            val charactersViewModel = hiltViewModel<CharactersViewModel>()
            val characterState = charactersViewModel.charactersState.collectAsStateWithLifecycle().value

            CharacterScreen(modifier = Modifier, characterState = characterState)
        }
    }
}