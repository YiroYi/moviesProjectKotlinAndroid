package com.example.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclient.data.model.tvshow.TvShow

@Dao
interface TvShowDAO {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun saveTvShow(movies: List<TvShow>)

  @Query("DELETE FROM popular_tv_shows")
  suspend fun deleteAllTvShows()

  @Query("SELECT * FROM popular_tv_shows")
  suspend fun getTvShows():List<TvShow>
}