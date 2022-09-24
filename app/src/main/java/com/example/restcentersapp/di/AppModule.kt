package com.example.restcentersapp.di

import com.example.restcentersapp.data.remote.RestPlacesApi
import com.example.restcentersapp.data.repository.BlogRepositoryImpl
import com.example.restcentersapp.data.repository.FoodRepositoryImpl
import com.example.restcentersapp.domain.repository.BlogRepository
import com.example.restcentersapp.domain.repository.FoodRepository
import com.example.restcentersapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRespPlacesApi(): RestPlacesApi {

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val builder = OkHttpClient.Builder()
        builder.networkInterceptors().add(httpLoggingInterceptor)
        val okHttpClient = builder.build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RestPlacesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFoodRepository(api: RestPlacesApi): FoodRepository{
        return FoodRepositoryImpl(api = api)
    }

    @Provides
    @Singleton
    fun provideBlogRepository(api: RestPlacesApi): BlogRepository{
        return BlogRepositoryImpl(api = api)
    }

}