package com.example.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.tvshow.TvShow

@Database(
  entities = [Movie::class, TvShow::class, Artist::class],
  version = 1,
  exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {
  abstract fun movieDao() : MovieDAO
  abstract fun tvDao() : TvShowDAO
  abstract fun artistDao() : ArtistDAO
}