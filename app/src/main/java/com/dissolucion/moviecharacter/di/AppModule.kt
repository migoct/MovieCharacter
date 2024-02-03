package com.dissolucion.moviecharacter.di

import com.dissolucion.moviecharacter.core.utils.Constants.BASE_URL
import com.dissolucion.moviecharacter.data.api.CharacterApi
import com.dissolucion.moviecharacter.data.repository.CharacterRepositoryImpl
import com.dissolucion.moviecharacter.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

    @Provides
    @Singleton
    fun provideCharacterApi(retrofit: Retrofit): CharacterApi =
        retrofit.create(CharacterApi::class.java)

    @Provides
    @Singleton
    fun provideCharacterRepository(characterApi: CharacterApi): CharacterRepository =
        CharacterRepositoryImpl(characterApi)
}