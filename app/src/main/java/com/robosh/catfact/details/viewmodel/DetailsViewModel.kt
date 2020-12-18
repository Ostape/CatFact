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
        if (_state.value !is ResultState.DataListState) {
            val source = catFactRepository.getCatFacts()
            _state.addSource(source) {
                _state.postValue(it)
                _state.removeSource(source)
            }
        }
    }
}