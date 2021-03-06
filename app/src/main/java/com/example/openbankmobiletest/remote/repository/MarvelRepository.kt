package com.example.openbankmobiletest.remote.repository

import com.example.openbankmobiletest.model.CharacterDataWrapper
import com.example.openbankmobiletest.remote.datasource.MarvelDataSourceRemote
import javax.inject.Inject

class MarvelRepository @Inject constructor(private val dataSourceRemote: MarvelDataSourceRemote) {

    suspend fun getCharacters(offset: Int): CharacterDataWrapper {
        val response = dataSourceRemote.getCharacters(offset)
        return response.body() ?: CharacterDataWrapper(0, "Unknown error", null)
    }

    suspend fun getCharacterById(characterId: Int): CharacterDataWrapper {
        val response = dataSourceRemote.getCharacterById(characterId)

        return response.body() ?: CharacterDataWrapper(0, "Unknown error", null)
    }

}