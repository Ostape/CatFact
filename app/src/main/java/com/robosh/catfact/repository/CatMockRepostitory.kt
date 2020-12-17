package com.robosh.catfact.repository

import com.robosh.catfact.model.CatFact

class CatMockRepostitory {

    fun getCatFacts(): List<CatFact> {
        return mutableListOf(
            CatFact("asdsa", "1sadasdas"),
            CatFact("asds", "1ssadfasafdasd"),
            CatFact("asds", "1safdassadasd"),
            CatFact("asds", "1safda21esd"),
            CatFact("asds", "4235safdasd"),
            CatFact("asds", "21safdasd"),
            CatFact("asds", "sdfasdsafdasd")
        )
    }
}