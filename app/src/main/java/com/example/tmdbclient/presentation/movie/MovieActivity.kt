package com.example.tmdbclient.presentation.movie

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityMovieBinding
import com.example.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
  @Inject
  lateinit var factory: MovieViewModelFactory
  lateinit var movieViewModel: MovieViewModel
  lateinit var binding: ActivityMovieBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()

     binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
    (application as Injector).createMovieSubComponent()
      .inject(this)

    movieViewModel = ViewModelProvider(this, factory)
      .get(MovieViewModel::class.java)

    val responseLiveData = movieViewModel.getMovies()

    responseLiveData.observe(this, Observer {
      Log.i("MYTAG", it.toString())
    })
  }
}