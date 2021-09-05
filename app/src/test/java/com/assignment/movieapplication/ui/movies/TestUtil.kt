
package com.assignment.movieapplication.ui.movies


import com.assignment.movieapplication.model.movie.Movie

import java.util.concurrent.ThreadLocalRandom


object TestUtil {



    fun createMovies(count: Int, title: String): List<Movie> {
        return (0 until count).map {
            createMovie(title)
        }
    }





    fun createMovie(title: String) = Movie(
        93.929,
        9331,
        true,
        "/gajva2L0wwwEWjzgFlBXCAVBE5.jpg",
        randomInt(),
        true,
        "/8QXGNP0wwwwnsYKub59XpAhiUSQN.jpg",
        "en",
        "Test Movie",
        arrayListOf<Int>(),
        title,
        7.4,
        "Test",
        "/gajva2L0wwwEWjzgFlBXCAVBE5.jpg"
    )




    fun randomInt(): Int {
        return ThreadLocalRandom.current().nextInt(0, 1000 + 1)
    }
}
