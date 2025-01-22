package com.example.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.tmdbclient.data.db.ArtistDAO
import com.example.tmdbclient.data.db.MovieDAO
import com.example.tmdbclient.data.db.TMDBDatabase
import com.example.tmdbclient.data.db.TvShowDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
  @Singleton
  @Provides
  fun provideMovieDatabase(context: Context): TMDBDatabase {
    return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient").build()
  }

  @Singleton
  @Provides
  fun provideMovieDao(tmdmDatabase: TMDBDatabase) : MovieDAO {
    return tmdmDatabase.movieDao()
  }

  @Singleton
  @Provides
  fun provideArtistDao(tmdmDatabase: TMDBDatabase) : ArtistDAO {
    return tmdmDatabase.artistDao()
  }

  @Singleton
  @Provides
  fun provideTvShowDao(tmdmDatabase: TMDBDatabase) : TvShowDAO {
    return tmdmDatabase.tvDao()
  }
}