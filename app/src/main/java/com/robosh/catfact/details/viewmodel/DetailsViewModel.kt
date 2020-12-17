package com.robosh.catfact.details.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.robosh.catfact.model.CatFact
import com.robosh.catfact.net.repository.CatFactRepository

class DetailsViewModel(
    private val catFactRepository: CatFactRepository
) : ViewModel() {

    // todo wrap model with result
    fun getCatFacts(): LiveData<List<CatFact>> {
        return catFactRepository.getCatFacts()
    }
}