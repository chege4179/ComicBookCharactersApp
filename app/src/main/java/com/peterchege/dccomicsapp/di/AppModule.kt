package com.peterchege.dccomicsapp.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.provider.SyncStateContract
import androidx.room.Room
import com.peterchege.dccomicsapp.api.DCComicsApi
import com.peterchege.dccomicsapp.util.Constants


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDCComicsApi():DCComicsApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(DCComicsApi::class.java)
    }

}
