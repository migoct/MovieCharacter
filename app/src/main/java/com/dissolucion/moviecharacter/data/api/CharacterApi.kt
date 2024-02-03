package com.dissolucion.moviecharacter.data.api

import com.dissolucion.moviecharacter.data.dto.CharactersDto
import retrofit2.http.GET

interface CharacterApi {

    @GET("characters")
    suspend fun getAllCharacters(): List<CharactersDto>
}