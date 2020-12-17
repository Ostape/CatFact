package com.robosh.catfact.details

import com.robosh.catfact.model.CatFact

interface CatFactClickListenerFactory {

    fun createOnClickListener(catFact: CatFact)
}