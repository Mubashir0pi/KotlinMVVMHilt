package com.assignment.movieapplication.adapter.genres

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.movieapplication.databinding.GenresMovieItemBinding
import com.assignment.movieapplication.model.moviedetail.GenresItem

class GenresMovieViewHolder(private val binding: GenresMovieItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: GenresItem?, clickListener: GenresMovieClickListener) {
        binding.movie = item
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): GenresMovieViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = GenresMovieItemBinding.inflate(inflater, parent, false)

            return GenresMovieViewHolder(binding)
        }
    }
}