package com.example.tmdbclient.data.repository.tvshow

import android.util.Log
import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.example.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
  private val tvShowRemoteDatasource: TvShowRemoteDatasource,
  private val tvShowLocalDataSource: TvShowLocalDataSource,
  private val tvShowCacheDataSource: TvShowCacheDataSource,
) : TvShowRepository {

  override suspend fun getTvShows(): List<TvShow>? {
    return getTvShowsFromCache()
  }

  override suspend fun updateTvShows(): List<TvShow>? {
    val newListOfTvShows = getTvShowsFromAPI()
    tvShowLocalDataSource.clearAll()
    tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
    tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
    return newListOfTvShows
  }

  suspend fun getTvShowsFromAPI(): List<TvShow> {
    lateinit var movieList: List<TvShow>

    try {
      val response = tvShowRemoteDatasource.getTvShows()
      val body = response.body()

      if (body != null) {
        movieList = body.tvShows
      }
    } catch (exception: Exception) {
      Log.i("MYTAG", exception.message.toString())
    }
    return movieList
  }

  suspend fun getTvShowsFromDB(): List<TvShow> {
    lateinit var movieList: List<TvShow>

    try {
      movieList = tvShowLocalDataSource.getTvShowsFromDB()
    } catch (exception: Exception) {
      Log.i("MYTAG", exception.message.toString())
    }

    if (movieList.size > 0) {
      return movieList
    } else {
      movieList=getTvShowsFromAPI()
      tvShowLocalDataSource.saveTvShowsToDB(movieList)
    }

    return movieList
  }

  suspend fun getTvShowsFromCache(): List<TvShow> {
    lateinit var movieList: List<TvShow>

    try {
      movieList = tvShowCacheDataSource.getTvShowsFromCache()
    } catch (exception: Exception) {
      Log.i("MYTAG", exception.message.toString())
    }

    if (movieList.size > 0) {
      return movieList
    } else {
      movieList=getTvShowsFromDB()
      tvShowCacheDataSource.saveTvShowsToCache(movieList)
    }

    return movieList
  }
}