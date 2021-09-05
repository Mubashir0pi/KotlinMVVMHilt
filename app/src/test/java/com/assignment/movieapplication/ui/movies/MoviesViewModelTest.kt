package com.assignment.movieapplication.ui.movies

import com.assignment.movieapplication.data.Repository
import com.assignment.movieapplication.network.ApiInteface
import junit.framework.TestCase

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito

class MoviesViewModelTest : TestCase() {

    private lateinit var viewModel:MoviesViewModel
    @Before
    public override fun setUp() {
        viewModel = Mockito.mock(MoviesViewModel::class.java)
    }

    @After
    public override fun tearDown() {
    }

    @Test
    fun onCleared() {
    }

    @Test
    fun clear() {
    }

    @Test
    fun getTag() {
    }

    @Test
    fun getMoviesList() {
    }

    @Test
    fun getMovieDetail() {
    }
}