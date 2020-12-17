package com.robosh.catfact.application

import io.reactivex.Observable

fun <T> Iterable<Observable<T?>>?.toObservableList(): Observable<List<T>> {
    return if (this == null || this.toList().isEmpty())
        return Observable.just(emptyList())
    else Observable.zip(this) { r -> r.map { it as T } }
}