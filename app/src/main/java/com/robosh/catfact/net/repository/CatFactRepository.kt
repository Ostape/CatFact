package com.robosh.catfact.net.repository

import androidx.lifecycle.LiveData
import com.robosh.catfact.model.ResultState

interface CatFactRepository {

    fun getCatFacts(): LiveData<ResultState>
}