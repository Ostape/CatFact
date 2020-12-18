package com.robosh.catfact.net

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitCatFactTextClientInstance {

    private lateinit var retrofit: Retrofit
    private const val BASE_URL = "https://cat-fact.herokuapp.com/"

    val retrofitInstance: Retrofit
        get() {
            if (this::retrofit.isInitialized) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            }
            return retrofit
        }
}