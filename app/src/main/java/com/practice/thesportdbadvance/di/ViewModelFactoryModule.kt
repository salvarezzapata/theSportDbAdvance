package com.practice.thesportdbadvance.di

import androidx.lifecycle.ViewModelProvider
import com.practice.thesportdbadvance.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}