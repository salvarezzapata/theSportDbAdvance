package com.practice.thesportdbadvance.di

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideString(): String {
        return "Hello world with android dagger!"
    }
}