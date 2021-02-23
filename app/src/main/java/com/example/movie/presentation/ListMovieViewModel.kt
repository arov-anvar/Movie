package com.example.movie.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movie.domain.ListMovieInteractor

class ListMovieViewModel(private val interactor: ListMovieInteractor) : ViewModel() {

    val listMovie = MutableLiveData<List<MovieItem>>()

    fun getListMovie() {
        interactor.getPopularMovieList()
            .subscribe(
                { listPopularMovie ->
                    listMovie.value = listPopularMovie.map { movieDomain ->
                        MovieItem(
                            posterUrl = movieDomain.posterPath,
                            title = movieDomain.title
                        )
                    }
                },
                {
                    Log.e("anvar_err", it.message.toString())
                }
            )
    }
}