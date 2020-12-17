package com.robosh.catfact.net.repository

import androidx.lifecycle.LiveData
import com.robosh.catfact.model.CatFact

interface CatFactRepository {

    fun getCatFacts(): LiveData<List<CatFact>>
}