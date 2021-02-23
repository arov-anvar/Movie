package com.example.movie.di

import com.example.movie.BuildConfig
import com.example.movie.data.remote.ListMovieApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { provideListMovieApiService(get()) }
}

internal fun provideOkHttpClient(): OkHttpClient {
    val requestInterceptor = Interceptor { chain ->

        val url = chain.request()
            .url
            .newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY)
            .build()

        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()

        return@Interceptor chain.proceed(request)
    }

    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    return OkHttpClient().newBuilder()
        .addInterceptor(logging)
        .addInterceptor(requestInterceptor)
        .build()
}

internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
     Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

internal fun provideListMovieApiService(retrofit: Retrofit): ListMovieApiService =
    retrofit.create(ListMovieApiService::class.java)