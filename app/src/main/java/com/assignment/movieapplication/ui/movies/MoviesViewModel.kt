package com.assignment.movieapplication.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.assignment.movieapplication.data.Repository
import com.assignment.movieapplication.model.movie.Movie
import com.assignment.movieapplication.model.moviedetail.MovieDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repository: Repository,
) :
    ViewModel() {
    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var data: Flow<PagingData<Movie>>? = null
    private var movieDetailResult: MutableLiveData<MovieDetail>? = null

    fun getMoviesList(sortBy: String): Flow<PagingData<Movie>> {
        
        val results = repository.getMovieListing(sortBy)
            .cachedIn(viewModelScope)
        data = results

        return data!!

    }

    fun getMovieDetail(id:String): LiveData<MovieDetail> {
        val movieDetail = MutableLiveData<MovieDetail>()


        uiScope.launch {
            movieDetail.value = repository.getMovieDetails(id)
            movieDetailResult = movieDetail
        }
        return movieDetail
    }

}