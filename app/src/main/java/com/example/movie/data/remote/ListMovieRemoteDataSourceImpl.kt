package com.example.movie.data.remote

import com.example.movie.data.remote.model.ListMovieModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class ListMovieRemoteDataSourceImpl(private val listMovieApiService: ListMovieApiService) : ListMovieRemoteDataSource {

    override fun getPopularMovieList(): Single<ListMovieModel> =
        listMovieApiService.getPopularMovie()
}