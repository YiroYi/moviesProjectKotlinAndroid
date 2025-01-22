package com.example.tmdbclient.presentation.artist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {
  lateinit var binding: ActivityArtistBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()

     binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
  }
}