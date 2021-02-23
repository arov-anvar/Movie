package com.example.movie.di

import com.example.movie.domain.ListMovieInteractor
import com.example.movie.domain.ListMovieInteractorImpl
import org.koin.dsl.module

val interactorModule = module {
    single<ListMovieInteractor> { ListMovieInteractorImpl(get()) }
}