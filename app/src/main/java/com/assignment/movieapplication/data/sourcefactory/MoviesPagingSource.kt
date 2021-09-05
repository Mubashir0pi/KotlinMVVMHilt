package com.assignment.movieapplication.data.sourcefactory

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.assignment.movieapplication.model.movie.Movie
import com.assignment.movieapplication.network.ApiInteface
import com.assignment.movieapplication.utils.*
import retrofit2.HttpException
import java.io.IOException
import java.io.InvalidObjectException

class MoviesPagingSource(
    private val service: ApiInteface,
    private val sortBy: String?,
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: 1
        return try {
            val response = if (sortBy != null ) {
                service.getMovies(sortBy,PRIMARY_RELEASE_DATE, API_KEY, page)
            } else {
                throw InvalidObjectException("value should not be null!")
            }


            response.results

            LoadResult.Page(
                data = response.results,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.results.isEmpty()) null else page + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }



    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }
}