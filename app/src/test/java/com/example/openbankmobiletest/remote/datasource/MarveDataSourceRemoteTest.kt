package com.example.openbankmobiletest.remote.datasource

import com.example.openbankmobiletest.model.CharacterDataContainer
import com.example.openbankmobiletest.model.CharacterDataWrapper
import com.example.openbankmobiletest.remote.api.MarvelAPI
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.OverrideMockKs
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Response
import retrofit2.Retrofit

@ExperimentalCoroutinesApi
class MarveDataSourceRemoteTest {

    @MockK
    private lateinit var retrofit: Retrofit

    @MockK
    private lateinit var api: MarvelAPI

    @InjectMockKs
    private lateinit var datasource: MarvelDataSourceRemote

    val expectedDataWrapper = CharacterDataWrapper(200, "success", CharacterDataContainer(0 ,0, 0, 0, emptyList()))

    @Before
    fun setUp() {

        MockKAnnotations.init(this)

        every { retrofit.create<MarvelAPI>(any()) } returns api

    }

    @Test
    fun get_characters_return_same_response() {

        coEvery { api.getCharacters(0, "api_key", 0, "hash") } returns Response.success(expectedDataWrapper)

        runBlockingTest {

            val result = datasource.getCharacters(0)
            assertEquals(result, expectedDataWrapper)

        }

    }

    @Test
    fun get_character_by_id_return_same_response() {

        coEvery { api.getCharacterById(0, "api_key", 0, "hash") } returns Response.success(expectedDataWrapper)

        runBlockingTest {

            val result = datasource.getCharacterById(0)
            assertEquals(result, expectedDataWrapper)

        }

    }

}