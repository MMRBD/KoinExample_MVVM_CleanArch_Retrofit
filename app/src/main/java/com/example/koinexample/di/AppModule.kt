package com.example.koinexample.di

import com.example.koinexample.data.network.ApiInterface
import com.example.koinexample.data.repo.MediaRepository
import com.example.koinexample.data.repo.MediaRepositoryImpl
import com.example.koinexample.viewmodel.MediaViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://apivegans.veganslab.xyz/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }

    single<MediaRepository> {
        MediaRepositoryImpl(get())
    }
//
    viewModel {
        MediaViewModel(get())
    }
}