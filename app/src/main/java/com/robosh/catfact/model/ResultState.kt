package com.robosh.catfact.model

sealed class ResultState {
    object LoadingState : ResultState()
    data class DataListState(val data: List<CatFact>) : ResultState()
    data class ErrorState(val data: String) : ResultState()
}