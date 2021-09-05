package com.assignment.movieapplication.network

import com.assignment.movieapplication.model.movie.MovieData
import com.assignment.movieapplication.model.moviedetail.MovieDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInteface {

    @GET("discover/movie")
    suspend fun getMovies(
        @Query("sort_by") sortBy: String,
        @Query("primary_release_date.lte") primaryReleaseDate: String,
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): MovieData

    @GET("movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id: String,
        @Query("api_key") apiKey: String,
    ): MovieDetail

}


