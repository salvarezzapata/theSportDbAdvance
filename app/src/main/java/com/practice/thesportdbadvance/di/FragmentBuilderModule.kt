package com.practice.thesportdbadvance.di

import com.practice.thesportdbadvance.teamlist.view.TeamListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentBuilderModule {

    @ContributesAndroidInjector
    fun provideTeamListFragment(): TeamListFragment
}