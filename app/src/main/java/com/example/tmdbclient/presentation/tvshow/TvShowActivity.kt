package com.example.tmdbclient.presentation.tvshow

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityTvShowBinding

class TvShowActivity : AppCompatActivity() {
  lateinit var binding: ActivityTvShowBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_tv_show)

    binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
  }
}