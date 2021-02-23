package com.example.movie.di

import com.example.movie.data.local.ListMovieLocalDataSource
import com.example.movie.data.local.ListMovieLocalDataSourceImpl
import org.koin.dsl.module

val localDataSourceModule = module {
    single<ListMovieLocalDataSource> { ListMovieLocalDataSourceImpl() }
}