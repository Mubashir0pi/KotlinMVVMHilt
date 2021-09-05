package com.assignment.movieapplication.ui.movies

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.assignment.movieapplication.R
import com.assignment.movieapplication.adapter.loadstate.LoadStateAdapter
import com.assignment.movieapplication.adapter.movie.MovieAdapter
import com.assignment.movieapplication.adapter.movie.MovieClickListener
import com.assignment.movieapplication.databinding.FragmentMoviesBinding
import com.assignment.movieapplication.utils.SORT_BY_A_TO_Z
import com.assignment.movieapplication.utils.SORT_BY_RATING
import com.assignment.movieapplication.utils.SORT_BY_RELEASE_DATE
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MoviesFragment : Fragment() {

    private lateinit var binding: FragmentMoviesBinding
    private val viewModel: MoviesViewModel by viewModels()
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        setupActionBar()
        return binding.root
    }

    private fun setupActionBar() {
        val title = getString(R.string.movies)

        ((activity as AppCompatActivity).supportActionBar)?.title = title
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initComponents()

        fetchMovies(SORT_BY_RELEASE_DATE)

    }

    private fun fetchMovies(sortBy: String) {

        lifecycleScope.launch {
            viewModel.getMoviesList(sortBy).collectLatest {

                adapter.submitData(it)
            }
        }
    }

    private fun initComponents() {
        setHasOptionsMenu(true)
        binding.lifecycleOwner = viewLifecycleOwner
        initAdapter()
        binding.buttonRetry.setOnClickListener { adapter.retry() }
        binding.pullToRefresh.setOnRefreshListener(OnRefreshListener {
            fetchMovies(SORT_BY_RELEASE_DATE)
            binding.pullToRefresh.isRefreshing = false
        })

    }

    private fun initAdapter() {
        adapter = MovieAdapter(
            MovieClickListener {
                findNavController().navigate(
                    MoviesFragmentDirections.actionMoviesFragmentToDetailsFragment(
                        it
                    )
                )

            }).apply {
            addLoadStateListener { loadState ->
                binding.pullToRefresh.isRefreshing = false
                binding.movieList.isVisible = loadState.source.refresh is LoadState.NotLoading
                binding.movieProgress.isVisible = loadState.source.refresh is LoadState.Loading
                binding.buttonRetry.isVisible = loadState.source.refresh is LoadState.Error
                binding.moviesError.isVisible = loadState.source.refresh is LoadState.Error
            }
        }

        binding.movieList.adapter = adapter.withLoadStateHeaderAndFooter(
            header = LoadStateAdapter { adapter.retry() },
            footer = LoadStateAdapter { adapter.retry() }
        )

        binding.movieList.hasFixedSize()
        val layoutManager = LinearLayoutManager(activity)

        binding.movieList.layoutManager = layoutManager
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)

        implementMenu(menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun implementMenu(menu: Menu) {
        val expandListener = object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(p0: MenuItem?): Boolean {
                return true
            }

            override fun onMenuItemActionCollapse(p0: MenuItem?): Boolean {
                return true
            }
        }

        val releaseDate = menu.findItem(R.id.ic_sort_date)
        val a_to_z = menu.findItem(R.id.ic_sort_a_to_z)
        val rating = menu.findItem(R.id.ic_sort_rating)
        releaseDate.setOnActionExpandListener(expandListener)
        a_to_z.setOnActionExpandListener(expandListener)
        rating.setOnActionExpandListener(expandListener)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.ic_sort_date -> fetchMovies(SORT_BY_RELEASE_DATE)

            R.id.ic_sort_a_to_z -> fetchMovies(SORT_BY_A_TO_Z)

            R.id.ic_sort_rating -> fetchMovies(SORT_BY_RATING)

        }
        return NavigationUI.onNavDestinationSelected(
            item,
            findNavController()
        ) || super.onOptionsItemSelected(item)
    }

}




