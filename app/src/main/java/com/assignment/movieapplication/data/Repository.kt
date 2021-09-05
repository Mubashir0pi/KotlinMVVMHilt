package com.assignment.movieapplication.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.assignment.movieapplication.data.sourcefactory.MoviesPagingSource
import com.assignment.movieapplication.model.movie.Movie
import com.assignment.movieapplication.model.moviedetail.MovieDetail
import com.assignment.movieapplication.network.ApiInteface
import com.assignment.movieapplication.utils.API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class Repository

@Inject constructor(
    private val service: ApiInteface
) {

    fun getMovieListing(sortBy: String?):
            Flow<PagingData<Movie>> {
        return Pager(config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = false
        ),
            pagingSourceFactory = {
                MoviesPagingSource(
                    service,
                    sortBy
                )
            }).flow
    }

    suspend fun getMovieDetails(movieId: String): MovieDetail {
        return withContext(Dispatchers.IO) {
            service.getMovieDetails(movieId, API_KEY)
        }
    }


}