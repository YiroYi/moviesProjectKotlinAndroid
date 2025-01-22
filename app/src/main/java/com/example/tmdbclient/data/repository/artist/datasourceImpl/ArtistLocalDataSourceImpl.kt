package com.example.tmdbclient.data.repository.artist.datasourceImpl

import com.example.tmdbclient.data.db.ArtistDAO
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(
  private val artistDAO: ArtistDAO): ArtistLocalDataSource {
  override suspend fun getArtistsFromDB(): List<Artist> {
    return artistDAO.getArtists()
  }

  override suspend fun saveArtistsToDB(artists: List<Artist>) {
    CoroutineScope((Dispatchers.IO)).launch {
      artistDAO.saveArtist(artists)
    }
  }

  override suspend fun clearAll() {
    CoroutineScope((Dispatchers.IO)).launch {
      artistDAO.deleteAllArtists()
    }
  }
}