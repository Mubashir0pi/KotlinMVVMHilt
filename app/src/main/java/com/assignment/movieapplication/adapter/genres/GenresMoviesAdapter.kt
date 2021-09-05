package com.assignment.movieapplication.adapter.genres

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.assignment.movieapplication.model.moviedetail.GenresItem

class GenresMoviesAdapter(val clickListener: GenresMovieClickListener) :
    ListAdapter<GenresItem, RecyclerView.ViewHolder>(PersonMovieDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return GenresMovieViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as GenresMovieViewHolder).bind(getItem(position), clickListener)
    }

}

class PersonMovieDiffUtilCallback : DiffUtil.ItemCallback<GenresItem>() {
    override fun areItemsTheSame(oldItem: GenresItem, newItem: GenresItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GenresItem, newItem: GenresItem): Boolean {
        return oldItem == newItem
    }

}

class GenresMovieClickListener(private val clickListener: (movie: GenresItem) -> Unit) {

    fun onClick(movie: GenresItem) = clickListener(movie)
}