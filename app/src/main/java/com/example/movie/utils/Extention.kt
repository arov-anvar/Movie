package com.example.movie.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.movie.BuildConfig
import com.example.movie.R

fun ImageView.downloadImge(url: String) {
    Glide.with(context)
        .load("https://image.tmdb.org/t/p/original$url")
        .centerCrop()
        .error(R.drawable.error)
        .placeholder(R.drawable.image_placeholder)
        .into(this)
}