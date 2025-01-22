package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.db.ArtistDAO
import com.example.tmdbclient.data.db.MovieDAO
import com.example.tmdbclient.data.db.TvShowDAO
import com.example.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.example.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
  @Singleton
  @Provides
  fun provideMovieLocalDatasource(movieDAO: MovieDAO): MovieLocalDataSource {
    return MovieLocalDataSourceImpl(movieDAO)
  }

  @Singleton
  @Provides
  fun provideArtistLocalDatasource(artisDAO: ArtistDAO ): ArtistLocalDataSource {
    return ArtistLocalDataSourceImpl(artisDAO)
  }

  @Singleton
  @Provides
  fun provideTvShowLocalDatasource(tvShow: TvShowDAO): TvShowLocalDataSource {
    return TvShowLocalDataSourceImpl(tvShow)
  }
}