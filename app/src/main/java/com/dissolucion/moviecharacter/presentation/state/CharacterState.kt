package com.dissolucion.moviecharacter.presentation.state

import com.dissolucion.moviecharacter.domain.model.Characters

data class CharacterState(
    val isLoading: Boolean = false,
    val characters: List<Characters>? = emptyList(),
    val error: String? = ""
)
