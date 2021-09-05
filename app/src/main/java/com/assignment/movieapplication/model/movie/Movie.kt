package com.assignment.movieapplication.model.movie

import android.os.Parcelable
import androidx.paging.PagingData
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.coroutines.flow.Flow

@Parcelize
data class Movie(

    @SerializedName("popularity") val popularity: Double,
    @SerializedName("vote_count") val vote_count: Int,
    @SerializedName("video") val video: Boolean,
    @SerializedName("poster_path") val poster_path: String?,
    @SerializedName("id") val id: Int,
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("backdrop_path") val backdrop_path: String?,
    @SerializedName("original_language") val original_language: String,
    @SerializedName("original_title") val original_title: String,
    @SerializedName("genre_ids") val genre_ids: List<Int>,
    @SerializedName("title") val title: String,
    @SerializedName("vote_average") val vote_average: Double,
    @SerializedName("overview") val overview: String,
    @SerializedName("release_date") val release_date: String
) : Parcelable {

    val fullPosterPath: String
        get() = "http://image.tmdb.org/t/p/w342$poster_path"
    val fullBackDropPath: String
        get() = "http://image.tmdb.org/t/p/w780$backdrop_path"
}