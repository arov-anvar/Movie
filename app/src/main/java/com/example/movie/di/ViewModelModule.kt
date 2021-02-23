package com.example.movie.di

import com.example.movie.presentation.ListMovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ListMovieViewModel(get()) }
}