package com.assignment.movieapplication.model.moviedetail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SpokenLanguagesItem(

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("iso_639_1")
    val iso6391: String? = null,

    @SerializedName("english_name")
    val englishName: String? = null
): Parcelable {

}