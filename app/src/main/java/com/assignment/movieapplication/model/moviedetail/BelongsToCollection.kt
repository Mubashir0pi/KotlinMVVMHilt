package com.assignment.movieapplication.model.moviedetail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BelongsToCollection(

    @SerializedName("backdrop_path")
    val backdropPath: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("poster_path")
    val posterPath: String? = null
): Parcelable {

}