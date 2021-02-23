package com.example.movie.di

import com.example.movie.data.remote.ListMovieRemoteDataSource
import com.example.movie.data.remote.ListMovieRemoteDataSourceImpl
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single<ListMovieRemoteDataSource> { ListMovieRemoteDataSourceImpl(get()) }
}