package com.example.movie.data.remote

import com.example.movie.data.remote.model.ListMovieModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ListMovieApiService {

    @GET("movie/popular/")
    fun getPopularMovie(): Single<ListMovieModel>
}