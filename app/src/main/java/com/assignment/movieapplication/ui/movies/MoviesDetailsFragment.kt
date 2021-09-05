package com.assignment.movieapplication.ui.movies

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.assignment.movieapplication.adapter.genres.GenresMovieClickListener
import com.assignment.movieapplication.adapter.genres.GenresMoviesAdapter
import com.assignment.movieapplication.databinding.FragmentMovieDetailsBinding
import com.assignment.movieapplication.model.moviedetail.MovieDetail
import com.assignment.movieapplication.utils.Utils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesDetailsFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailsBinding
    private val viewModel: MoviesViewModel by viewModels()
    private lateinit var adapterGenres: GenresMoviesAdapter
    private lateinit var movie:MoviesDetailsFragmentArgs
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
         movie = MoviesDetailsFragmentArgs.fromBundle(requireArguments())

        setupActionBar(movie.Movie.title)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner

        initAdapters()

        viewModel.getMovieDetail(movie.Movie.id.toString()).observe(viewLifecycleOwner, {
            it?.let { movie: MovieDetail ->
                binding.data = movie
                binding.duration.text = """${it.runtime.toString()} MIN"""
                adapterGenres.submitList(it.genres)
            }
        })

    }

    private fun initAdapters() {

        binding.recyclerGenres.hasFixedSize()
        binding.recyclerGenres.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapterGenres = GenresMoviesAdapter(
            GenresMovieClickListener {
            })
        binding.recyclerGenres.adapter = adapterGenres

        binding.btBook.setOnClickListener {
            Utils.openUrl("https://www.cathaycineplexes.com.sg/",requireContext())
        }
    }


  

    private fun setupActionBar(name: String) {
        ((activity as AppCompatActivity).supportActionBar)?.title = name
    }


}