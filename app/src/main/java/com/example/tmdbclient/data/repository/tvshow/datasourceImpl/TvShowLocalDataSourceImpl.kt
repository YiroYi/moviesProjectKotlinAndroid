package com.example.tmdbclient.data.repository.tvshow.datasourceImpl


import com.example.tmdbclient.data.db.TvShowDAO
import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class TvShowLocalDataSourceImpl(
  private val tvShowDAO: TvShowDAO): TvShowLocalDataSource {
  override suspend fun getTvShowsFromDB(): List<TvShow> {
    return tvShowDAO.getTvShows()
  }

  override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
    CoroutineScope((Dispatchers.IO)).launch {
      tvShowDAO.saveTvShow(tvShows)
    }
  }

  override suspend fun clearAll() {
    CoroutineScope((Dispatchers.IO)).launch {
      tvShowDAO.deleteAllTvShows()
    }
  }
}