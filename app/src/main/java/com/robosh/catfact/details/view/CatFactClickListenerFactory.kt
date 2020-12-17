package com.robosh.catfact.details.view

import com.robosh.catfact.model.CatFact

interface CatFactClickListenerFactory {

    fun createOnClickListener(catFact: CatFact)
}