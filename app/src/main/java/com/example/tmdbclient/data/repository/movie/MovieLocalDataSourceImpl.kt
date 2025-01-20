package com.example.tmdbclient.data.repository.movie

import com.example.tmdbclient.data.db.MovieDAO
import com.example.tmdbclient.data.model.movie.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class MovieLocalDataSourceImpl(
  private val movieDAO: MovieDAO): MovieLocalDataSource {
  override suspend fun getMoviesFromDB(): List<Movie> {
    return movieDAO.getMovies()
  }

  override suspend fun saveMoviesToDV(movies: List<Movie>) {
    CoroutineScope((Dispatchers.IO)).launch {
      movieDAO.saveMovies(movies)
    }
  }

  override suspend fun clearAll() {
    CoroutineScope((Dispatchers.IO)).launch {
      movieDAO.deleteAllMovies()
    }
  }
}