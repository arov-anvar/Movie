package com.example.movie.domain

import com.example.movie.domain.model.PopularMovieModelDomain
import io.reactivex.rxjava3.core.Single

interface ListMovieInteractor {
    fun getPopularMovieList(): Single<List<PopularMovieModelDomain>>
}