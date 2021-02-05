package com.example.openbankmobiletest.master.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openbankmobiletest.model.CharacterDataWrapper
import com.example.openbankmobiletest.remote.repository.MarvelRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MasterViewModel @Inject constructor(private val repository: MarvelRepository) : ViewModel() {

    val characterDataWrapper: MutableLiveData<CharacterDataWrapper> by lazy {
        MutableLiveData()
    }

    fun getCharacters(offset: Int = 0) {

        viewModelScope.launch {

            val result = repository.getCharacters(offset)
            characterDataWrapper.postValue(result)

        }

    }

}