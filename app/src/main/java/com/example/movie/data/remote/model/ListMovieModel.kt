package com.example.movie.data.remote.model


import com.google.gson.annotations.SerializedName

data class ListMovieModel(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val resultModels: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)