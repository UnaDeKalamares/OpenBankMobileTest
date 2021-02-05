package com.example.openbankmobiletest.remote.repository

import com.example.openbankmobiletest.model.CharacterDataContainer
import com.example.openbankmobiletest.model.CharacterDataWrapper
import com.example.openbankmobiletest.remote.datasource.MarvelDataSourceRemote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Response

@ExperimentalCoroutinesApi
class MarvelRepositoryTest {

    @MockK
    private lateinit var marvelDataSourceRemote: MarvelDataSourceRemote

    @InjectMockKs
    private lateinit var repository: MarvelRepository

    val expectedDataWrapper = CharacterDataWrapper(200, "success", CharacterDataContainer(0 ,0, 0, 0, emptyList()))
    val expectedResponse = Response.success(expectedDataWrapper)

    @Before
    fun setUp() {

        MockKAnnotations.init(this)

    }

    @Test
    fun get_characters_return_same_result() {

        coEvery { marvelDataSourceRemote.getCharacters(0) } returns expectedResponse

        runBlockingTest {

            val response = repository.getCharacters(0)
            assertEquals(response, expectedDataWrapper)

        }

    }

    @Test
    fun get_character_by_id_return_same_result() {

        coEvery { marvelDataSourceRemote.getCharacterById(0) } returns expectedResponse

        runBlockingTest {

            val response = repository.getCharacterById(0)
            assertEquals(response, expectedDataWrapper)

        }

    }

}