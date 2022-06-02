package com.chapter8.mvvmjatpactcompose.di

import com.chapter8.mvvmjatpactcompose.network.FilmService
import com.chapter8.mvvmjatpactcompose.network.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private const val BASE_URL = "https://6254434289f28cf72b5aed04.mockapi.io/"

    private val logging: HttpLoggingInterceptor
        get() {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            return httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }
        }
    private val client = OkHttpClient.Builder().addInterceptor(logging).build()

    @Provides
    @Singleton
    fun provideRetrofitNews(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    @Provides
    @Singleton
    fun provideNewsFromApi(retrofit: Retrofit): FilmService =
        retrofit.create(FilmService::class.java)

    @Provides
    @Singleton
    @Named("staff")
    fun provideStafFromApi(retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)

}