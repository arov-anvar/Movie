package com.example.movie.di

import com.example.movie.data.ListMovieRepositoryImpl
import com.example.movie.domain.repository.ListMovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ListMovieRepository> { ListMovieRepositoryImpl(get(), get()) }
}