package com.assignment.movieapplication.ui.movies

import androidx.databinding.DataBindingComponent
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingData
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.assignment.movieapplication.MainActivity
import com.assignment.movieapplication.R
import com.assignment.movieapplication.databinding.FragmentMoviesBinding
import com.assignment.movieapplication.model.movie.Movie
import com.assignment.movieapplication.utils.SORT_BY_RATING
import kotlinx.coroutines.flow.Flow
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class MoviesFragmentTest {
    @Rule
    @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java, true, true)


    private lateinit var viewModel: MoviesViewModel
    private val results = MutableLiveData<List<Movie>>()

    @Before
    fun init() {
        viewModel = Mockito.mock(MoviesViewModel::class.java)



    }

    @Test
    fun loadResults() {
        val movie = TestUtil.createMovie("movie")
        results.postValue(listOf(movie))
        Espresso.onView(listMatcher().atPosition(0))
            .check(ViewAssertions.matches(ViewMatchers.hasDescendant(ViewMatchers.withText("movie"))))
    }

    private fun listMatcher(): RecyclerViewMatcher {
        return RecyclerViewMatcher(R.id.movie_list)
    }

}
