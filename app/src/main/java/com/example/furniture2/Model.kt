package com.example.furniture2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Model(
    val imageResource: Int,
    var title: String,
    var modelResourceId: Int
): Parcelable