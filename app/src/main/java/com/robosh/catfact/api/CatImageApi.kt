package com.robosh.catfact.api

import io.reactivex.Observable
import retrofit2.http.GET

interface CatImageApi {

    @GET("/meow ")
    fun getImageFile(): Observable<CatImageFileResponse>
}