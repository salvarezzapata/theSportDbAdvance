package com.practice.thesportdbadvance.di

import com.practice.domain.model.CoroutinesContextProvider
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideString(): String {
        return "Hello world with android dagger!"
    }

    @Provides
    fun provideContextProvider(): CoroutinesContextProvider {
        return CoroutinesContextProvider(Dispatchers.Main, Dispatchers.IO)
    }

}