package com.example.movie.domain

import com.example.movie.domain.model.PopularMovieModelDomain
import com.example.movie.domain.repository.ListMovieRepository
import io.reactivex.rxjava3.core.Single

class ListMovieInteractorImpl(private val repository: ListMovieRepository) : ListMovieInteractor {
    override fun getPopularMovieList(): Single<List<PopularMovieModelDomain>> {
        return repository.getPopularMovieList()
            .map { listMovieModel ->
                listMovieModel.resultModels.map {
                        PopularMovieModelDomain(
                            id = it.id,
                            originalLanguage = it.originalLanguage,
                            originalTitle = it.originalTitle,
                            overview = it.overview,
                            popularity = it.popularity,
                            posterPath = it.posterPath,
                            releaseDate = it.releaseDate,
                            title = it.title,
                            video = it.video,
                            voteAverage = it.voteAverage,
                            voteCount = it.voteCount
                        )
                    }
            }
    }
}