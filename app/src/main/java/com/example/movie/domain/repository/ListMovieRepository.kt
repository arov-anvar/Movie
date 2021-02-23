package com.example.movie.domain.repository

import com.example.movie.data.remote.model.ListMovieModel
import io.reactivex.rxjava3.core.Single

interface ListMovieRepository {
    fun getPopularMovieList(): Single<ListMovieModel>
}