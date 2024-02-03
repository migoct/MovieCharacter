package com.dissolucion.moviecharacter.data.mapper

import com.dissolucion.moviecharacter.data.dto.CharactersDto
import com.dissolucion.moviecharacter.domain.model.Characters

fun CharactersDto.toDomainCharacter() = Characters(
    id = id,
    name = name,
    image = image,
    actor = actor
)