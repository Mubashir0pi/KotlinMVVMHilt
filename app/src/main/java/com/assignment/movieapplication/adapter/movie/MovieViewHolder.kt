package com.assignment.movieapplication.adapter.movie

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.movieapplication.databinding.MovieItemBinding
import com.assignment.movieapplication.model.movie.Movie


class MovieViewHolder(private val binding: MovieItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(item: Movie?, clickListener: MovieClickListener) {
        binding.movie = item
        binding.popularty.text= """Popularity ${item!!.popularity}"""
        binding.clickListener = clickListener
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): MovieViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = MovieItemBinding.inflate(inflater, parent, false)
            return MovieViewHolder(
                binding
            )
        }
    }

}