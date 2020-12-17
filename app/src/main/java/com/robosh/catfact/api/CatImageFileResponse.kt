package com.robosh.catfact.api

import com.google.gson.annotations.SerializedName

data class CatImageFileResponse(
    @SerializedName("file")
    val file: String
)