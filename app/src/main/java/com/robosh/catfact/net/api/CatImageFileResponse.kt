package com.robosh.catfact.net.api

import com.google.gson.annotations.SerializedName

data class CatImageFileResponse(
    @SerializedName("file")
    val file: String
)