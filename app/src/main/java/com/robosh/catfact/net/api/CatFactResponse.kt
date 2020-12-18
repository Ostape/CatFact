package com.robosh.catfact.net.api

import com.google.gson.annotations.SerializedName

data class CatFactResponse(
    @SerializedName("type")
    val type: String?,
    @SerializedName("text")
    val text: String
)