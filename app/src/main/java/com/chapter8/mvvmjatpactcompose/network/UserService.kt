package com.chapter8.mvvmjatpactcompose.network

import com.chapter8.mvvmjatpactcompose.model.DataUserResponseItem
import retrofit2.http.GET

interface UserService {
    @GET("staf")
    suspend fun getAllStaff(): List<DataUserResponseItem>
}