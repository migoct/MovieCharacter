package com.dissolucion.moviecharacter.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dissolucion.moviecharacter.core.common.Resource
import com.dissolucion.moviecharacter.domain.usecase.GetAllCharacterUseCase
import com.dissolucion.moviecharacter.presentation.state.CharacterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val useCase: GetAllCharacterUseCase
) : ViewModel() {

    private val _charactersState = MutableStateFlow(CharacterState())
    val charactersState: StateFlow<CharacterState>
        get() = _charactersState

    init {
        getAllCharacters()
    }

    private fun getAllCharacters() {
        useCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    _charactersState.value = CharacterState().copy(
                        isLoading = true
                    )
                }
                is Resource.Success -> {
                    _charactersState.value = CharacterState().copy(
                        characters = it.data ?: emptyList()
                    )
                }
                is Resource.Error -> {
                    _charactersState.value = CharacterState().copy(
                        error = it.msg ?: "An unexpected error occurred"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}