package com.example.openbankmobiletest.remote.datasource

import com.example.openbankmobiletest.BuildConfig
import com.example.openbankmobiletest.model.CharacterDataWrapper
import com.example.openbankmobiletest.remote.api.MarvelAPI
import retrofit2.Response
import retrofit2.Retrofit
import java.math.BigInteger
import java.security.MessageDigest
import java.util.*
import javax.inject.Inject

class MarvelDataSourceRemote @Inject constructor(retrofit: Retrofit) {

    private val api = retrofit.create(MarvelAPI::class.java)

    private fun calculateHash(timeStamp: Long): String {

        val input = timeStamp.toString() + BuildConfig.MARVEL_PRIVATE_API_KEY + BuildConfig.MARVEL_API_KEY

        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

    suspend fun getCharacters(offset: Int): Response<CharacterDataWrapper> {
        val timeStamp = Calendar.getInstance().timeInMillis
        return api.getCharacters(offset, BuildConfig.MARVEL_API_KEY, timeStamp, calculateHash(timeStamp))
    }

    suspend fun getCharacterById(characterId: Int): Response<CharacterDataWrapper> {
        val timeStamp = Calendar.getInstance().timeInMillis
        return api.getCharacterById(characterId, BuildConfig.MARVEL_API_KEY, timeStamp, calculateHash(timeStamp))
    }

}