package com.robosh.catfact.details.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.robosh.catfact.model.CatFact

class DetailsViewModel : ViewModel() {

    // todo wrap model with result
    fun getCatFacts(): LiveData<CatFact> {
        return MutableLiveData<CatFact>()
    }
}