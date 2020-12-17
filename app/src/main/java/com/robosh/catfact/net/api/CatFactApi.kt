package com.robosh.catfact.net.api

import io.reactivex.Observable
import retrofit2.http.GET

interface CatFactApi {

    @GET("/facts")
    fun getCatFacts(): Observable<List<CatFactResponse>>
}