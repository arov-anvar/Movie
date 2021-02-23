package com.example.movie.data.remote

import com.example.movie.data.remote.model.ListMovieModel
import io.reactivex.rxjava3.core.Single

interface ListMovieRemoteDataSource {

    fun getPopularMovieList(): Single<ListMovieModel>
}