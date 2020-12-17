package com.robosh.catfact.details.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.robosh.catfact.model.ResultState
import com.robosh.catfact.net.repository.CatFactRepository


class DetailsViewModel(
    private val catFactRepository: CatFactRepository
) : ViewModel() {

    private val _state = MediatorLiveData<ResultState>()

    init {
        _state.value = ResultState.LoadingState
    }

    val state
        get() = _state as LiveData<ResultState>

    fun processAction() {
        _state.addSource(catFactRepository.getCatFacts()) {
            _state.postValue(it)
        }
    }
}