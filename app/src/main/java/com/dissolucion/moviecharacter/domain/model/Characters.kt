package com.dissolucion.moviecharacter.domain.model

import com.google.gson.annotations.SerializedName

data class Characters(
    val id: String,
    val name: String,
    val image: String,
    val actor: String
)