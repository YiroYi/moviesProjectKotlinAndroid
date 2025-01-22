package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.example.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.example.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.example.tmdbclient.domain.repository.ArtistRepository
import com.example.tmdbclient.domain.repository.MovieRepository
import com.example.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

  @Singleton
  @Provides
  fun provideMovieRepository(
    movieRemoteDatasource: MovieRemoteDatasource,
    movieLocalDataSource: MovieLocalDataSource,
    movieCacheDataSource: MovieCacheDataSource
  ): MovieRepository {
    return MovieRepositoryImpl (
      movieRemoteDatasource,
      movieLocalDataSource,
      movieCacheDataSource
    )
  }

  @Singleton
  @Provides
  fun provideArtistRepository(
    artistRemoteDatasource: ArtistRemoteDatasource,
    artistLocalDataSource: ArtistLocalDataSource,
    artistCacheDataSource: ArtistCacheDataSource
  ): ArtistRepository {
    return ArtistRepositoryImpl(
      artistRemoteDatasource,
      artistLocalDataSource,
      artistCacheDataSource
    )
  }

  @Singleton
  @Provides
  fun provideTvShowRepository(
    tvShowRemoteDatasource: TvShowRemoteDatasource,
    tvShowLocalDataSource: TvShowLocalDataSource,
    tvShowCacheDataSource: TvShowCacheDataSource
  ): TvShowRepository {
    return TvShowRepositoryImpl(
      tvShowRemoteDatasource,
      tvShowLocalDataSource,
      tvShowCacheDataSource
    )
  }
}