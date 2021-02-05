package com.example.openbankmobiletest.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openbankmobiletest.model.CharacterDataWrapper
import com.example.openbankmobiletest.remote.repository.MarvelRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val repository: MarvelRepository) : ViewModel() {

    val characterDataWrapper: MutableLiveData<CharacterDataWrapper> by lazy {
        MutableLiveData()
    }

    fun getCharacterById(id: Int) {

        viewModelScope.launch {

            val result = repository.getCharacterById(id)
            characterDataWrapper.postValue(result)

        }

    }

}