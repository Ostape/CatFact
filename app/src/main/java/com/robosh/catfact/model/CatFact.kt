package com.robosh.catfact.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CatFact(
    val imageUrl: String,
    val description: String
) : Parcelable