package com.example.tmdbclient.data.repository.movie.datasourceImpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.movie.MovieList
import com.example.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

abstract class MovieRemoteDataSourceImpl(
  private val tmdbService: TMDBService,
  private val apiKey: String
): MovieRemoteDatasource {
  override suspend fun getMovies(): Response<MovieList> {
    return tmdbService.getPopularMovies(apiKey)
  }
}