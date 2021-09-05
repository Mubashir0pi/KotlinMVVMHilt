package com.assignment.movieapplication.model.moviedetail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GenresItem(

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("id")
    val id: Int? = null
): Parcelable {

}
