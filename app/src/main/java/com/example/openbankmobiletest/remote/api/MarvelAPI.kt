package com.example.openbankmobiletest.remote.api

import com.example.openbankmobiletest.model.CharacterDataWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelAPI {

    @GET("/v1/public/characters")
    suspend fun getCharacters(@Query("apikey") apiKey: String, @Query("ts") timeStamp: Long, @Query("hash") hash: String): Response<CharacterDataWrapper>

    @GET("/v1/public/characters/{characterId}")
    suspend fun getCharacterById(@Path("characterId") characterId: Int, @Query("apikey") apiKey: String, @Query("ts") timeStamp: Long, @Query("hash") hash: String): Response<CharacterDataWrapper>


}