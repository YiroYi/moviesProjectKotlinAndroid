package com.example.tmdbclient.data.repository.artist.datasourceImpl

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.repository.artist.datasource.ArtisCacheDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource

abstract class ArtistCacheDataSourceImpl: ArtisCacheDataSource {
  private var artistList = ArrayList<Artist>()
  override suspend fun getArtistsFromCache(): List<Artist> {
    return artistList
  }

  override suspend fun saveArtistsToCache(artists: List<Artist>) {
    artistList.clear()
    artistList = ArrayList(artists)
  }
}