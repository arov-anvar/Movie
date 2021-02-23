package com.example.movie.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.movie.R
import kotlinx.android.synthetic.main.fragment_list_movie.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListMovieFragment : Fragment(R.layout.fragment_list_movie) {

    private val viewModel: ListMovieViewModel by viewModel()
    private val adapter = ListMovieAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieRV.adapter = adapter

        viewModel.getListMovie()
        viewModel.listMovie.observe(this, {
            adapter.setData(it)
        })

    }
}