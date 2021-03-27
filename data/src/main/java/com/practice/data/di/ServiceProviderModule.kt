package com.practice.data.di

import com.practice.data.network.BASE_URL
import com.practice.data.network.RetrofitInterceptor
import com.practice.data.network.SportService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ServiceProviderModule {
    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient.Builder{
        var httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        httpClient.addInterceptor(RetrofitInterceptor())
        httpClient.cache(null)

        return httpClient
    }

    @Singleton
    @Provides
    fun provideRetrofit(httpClientBuilder: OkHttpClient.Builder): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(
                httpClientBuilder.build()
            )
            .build()
    }

    @Singleton
    @Provides
    fun provideSportService(retrofit: Retrofit): SportService {
        return retrofit.create(SportService::class.java)
    }
}