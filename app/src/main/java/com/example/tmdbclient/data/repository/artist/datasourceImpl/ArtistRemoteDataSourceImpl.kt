package com.example.tmdbclient.data.repository.artist.datasourceImpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.artist.ArtistList
import com.example.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

abstract class ArtistRemoteDataSourceImpl(
  private val tmdbService: TMDBService,
  private val apiKey: String
): ArtistRemoteDatasource {
  override suspend fun getArtists(): Response<ArtistList> {
    return tmdbService.getPopularArtists(apiKey)
  }
}