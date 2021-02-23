package com.example.movie.data

import com.example.movie.data.local.ListMovieLocalDataSource
import com.example.movie.data.remote.ListMovieRemoteDataSource
import com.example.movie.data.remote.model.ListMovieModel
import com.example.movie.domain.repository.ListMovieRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class ListMovieRepositoryImpl(
    private val localDataSource: ListMovieLocalDataSource,
    private val remoteDataSource: ListMovieRemoteDataSource
) : ListMovieRepository {
    override fun getPopularMovieList(): Single<ListMovieModel> {
        return remoteDataSource.getPopularMovieList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    }

}