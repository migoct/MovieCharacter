package com.dissolucion.moviecharacter.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dissolucion.moviecharacter.presentation.navigation.Screen
import com.dissolucion.moviecharacter.presentation.state.CharacterState

@Composable
fun CharacterScreen(
    modifier : Modifier = Modifier,
    characterState: CharacterState
) {
    if (characterState.isLoading) {
        Box(
            modifier = modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    } else if (characterState.error?.isNotEmpty() == true) {
        Box(
            modifier = modifier.fillMaxSize()
        ) {
            Text(
                text = characterState.error.toString(),
                modifier = Modifier.align(Alignment.Center)
            )
        }

    }

    if (characterState.characters?.isNotEmpty()!!) {
        LazyColumn {
            items(characterState.characters) { character ->
                CharacterItem(modifier = modifier, character = character)
            }
        }
    }
}