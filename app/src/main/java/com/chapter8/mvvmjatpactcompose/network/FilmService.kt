package com.chapter8.mvvmjatpactcompose.network

import com.chapter8.mvvmjatpactcompose.model.DataFilmResponseItem
import retrofit2.http.GET

interface FilmService {
    @GET("news")
    suspend fun getAllNews(): List<DataFilmResponseItem>
}