package com.example.tmdbclient.presentation.movie

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {
  lateinit var binding: ActivityMovieBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()

     binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
  }
}