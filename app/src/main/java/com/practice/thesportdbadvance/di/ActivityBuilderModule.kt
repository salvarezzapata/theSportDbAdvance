package com.practice.thesportdbadvance.di

import com.practice.thesportdbadvance.MainActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(
        modules = [
            FragmentBuilderModule::class,
            ViewModelModule::class
        ]
    )
    abstract fun bindMainActivity(): MainActivity
}