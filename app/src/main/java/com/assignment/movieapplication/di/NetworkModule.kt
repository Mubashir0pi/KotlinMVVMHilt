package com.assignment.movieapplication.di

import androidx.databinding.library.BuildConfig
import com.assignment.movieapplication.network.ApiInteface
import com.assignment.movieapplication.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiInteface {

        val client = OkHttpClient.Builder()

        /***Logger Enable for Debug version***/

        if (BuildConfig.DEBUG) {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC
            client.addInterceptor(logger)
        }

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client.build())
            .build()
            .create(ApiInteface::class.java)
    }
}