package com.example.movie

import android.app.Application
import com.example.movie.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MovieApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MovieApp)
            modules(networkModule, remoteDataSourceModule, localDataSourceModule, repositoryModule, interactorModule, viewModelModule)
        }
    }
}