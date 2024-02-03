package com.dissolucion.moviecharacter.domain.repository

import com.dissolucion.moviecharacter.core.common.Resource
import com.dissolucion.moviecharacter.domain.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getAllCharacters() : Flow<Resource<List<Characters>>>
}