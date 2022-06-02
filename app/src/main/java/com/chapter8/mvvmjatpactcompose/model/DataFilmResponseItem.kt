package com.chapter8.mvvmjatpactcompose.model

import java.io.Serializable

data class DataFilmResponseItem(
    val author: String,
    val createdAt: String,
    val description: String,
    val id: String,
    val image: String,
    val title: String
): Serializable
