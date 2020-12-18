package com.robosh.catfact.net.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import com.robosh.catfact.application.toObservableList
import com.robosh.catfact.model.CatFact
import com.robosh.catfact.model.ResultState
import com.robosh.catfact.net.RetrofitClientInstance
import com.robosh.catfact.net.RetrofitInstance2
import com.robosh.catfact.net.api.CatFactApi
import com.robosh.catfact.net.api.CatImageApi
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class CatFactRepositoryImpl : CatFactRepository {

    override fun getCatFacts(): LiveData<ResultState> {
        val subscribe =
            RetrofitInstance2.retrofitInstance!!.create(CatFactApi::class.java).getCatFacts()
                .flatMap {
                    it.map { catFactResponse ->
                        RetrofitClientInstance.retrofitInstance!!.create(CatImageApi::class.java)
                            .getImageFile().map {
                                Observable.just(CatFact(it.file, catFactResponse.text))
                            }
                            .onErrorReturn {
                                Observable.just(CatFact("", catFactResponse.text))
                            }
                            .blockingFirst()
                    }.toObservableList()
                }
                .map {
                    val dataListState = ResultState.DataListState(it)
                    dataListState as ResultState
                }
                .onErrorReturn{
                    ResultState.ErrorState(it.localizedMessage ?: "Error in getCatFacts")
                }
                .subscribeOn(Schedulers.io())

        return LiveDataReactiveStreams.fromPublisher(subscribe.toFlowable(BackpressureStrategy.DROP))
    }
}