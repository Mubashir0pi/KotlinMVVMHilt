package com.assignment.movieapplication.model.moviedetail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductionCountriesItem(

    @SerializedName("iso_3166_1")
    val iso31661: String? = null,

    @SerializedName("name")
    val name: String? = null
): Parcelable {

}