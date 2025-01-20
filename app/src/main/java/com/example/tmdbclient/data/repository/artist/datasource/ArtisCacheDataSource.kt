package com.example.tmdbclient.data.repository.artist.datasource

import com.example.tmdbclient.data.model.artist.Artist

interface ArtisCacheDataSource {
  suspend fun getArtistsFromCache(): List<Artist>
  suspend fun saveArtistsToCache(movies: List<Artist>)
}