package com.dissolucion.moviecharacter.data.repository

import com.dissolucion.moviecharacter.core.common.Resource
import com.dissolucion.moviecharacter.data.api.CharacterApi
import com.dissolucion.moviecharacter.data.mapper.toDomainCharacter
import com.dissolucion.moviecharacter.domain.model.Characters
import com.dissolucion.moviecharacter.domain.repository.CharacterRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ViewModelScoped
class CharacterRepositoryImpl @Inject constructor(
    private val characterApi: CharacterApi
): CharacterRepository {

    override fun getAllCharacters(): Flow<Resource<List<Characters>>> = flow{
        emit(Resource.Loading())
        val result = characterApi.getAllCharacters().map { it.toDomainCharacter() }
        emit(Resource.Success(result))
    }.flowOn(Dispatchers.IO)
        .catch { e ->
            emit(Resource.Error(e.message ?: "An error occurred"))
        }
}
