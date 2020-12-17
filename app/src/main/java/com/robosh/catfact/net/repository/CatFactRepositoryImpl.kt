package com.robosh.catfact.net.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.robosh.catfact.model.CatFact

class CatFactRepositoryImpl : CatFactRepository {

    override fun getCatFacts(): LiveData<List<CatFact>> {
        return MutableLiveData<List<CatFact>>().apply {
            postValue(
                mutableListOf(
                    CatFact("asdsa", "1sadasdas"),
                    CatFact("asds", "1ssadfasafdasd"),
                    CatFact("asds", "1safdassadasd"),
                    CatFact("asds", "1safda21esd"),
                    CatFact("asds", "4235safdasd"),
                    CatFact("asds", "21safdasd"),
                    CatFact("asds", "sdfasdsafdasd")
                )
            )
        }
    }
}