package com.example.tmdbclient.data.repository.tvshow.datasourceImpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.tvshow.TvShowList
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
  private val tmdbService: TMDBService,
  private val apiKey: String
): TvShowRemoteDatasource {
  override suspend fun getTvShows(): Response<TvShowList> {
    return tmdbService.getPopularTvShows(apiKey)
  }
}