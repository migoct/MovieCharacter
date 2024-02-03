package com.dissolucion.moviecharacter.domain.usecase

import com.dissolucion.moviecharacter.domain.repository.CharacterRepository
import javax.inject.Inject

class GetAllCharacterUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {
    operator fun invoke() = characterRepository.getAllCharacters()
}
