package com.example.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.usecase.GetArtistsUseCase
import com.example.tmdbclient.domain.usecase.UpdateArtistsUseCase


class ArtistViewModelFactory(
  private val getArtistsUseCase: GetArtistsUseCase,
  private val updateArtistUseCase: UpdateArtistsUseCase
): ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return ArtistViewModel(
      getArtistsUseCase,
      updateArtistUseCase
    ) as T
  }
}