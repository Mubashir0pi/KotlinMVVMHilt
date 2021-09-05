package com.assignment.movieapplication.model.moviedetail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductionCompaniesItem(

    @SerializedName("logo_path")
    val logoPath: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("origin_country")
    val originCountry: String? = null
) : Parcelable {

}