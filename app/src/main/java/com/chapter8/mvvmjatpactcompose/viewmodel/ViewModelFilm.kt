package com.chapter8.mvvmjatpactcompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chapter8.mvvmjatpactcompose.model.DataFilmResponseItem
import com.chapter8.mvvmjatpactcompose.network.FilmService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelFilm @Inject constructor(api: FilmService) : ViewModel() {
    private val filmState = MutableStateFlow(emptyList<DataFilmResponseItem>())
    val dataState: StateFlow<List<DataFilmResponseItem>> get() = filmState

    init {
        viewModelScope.launch {
            val dataFilm = api.getAllNews()
            filmState.value = dataFilm
        }
    }
}