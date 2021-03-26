package com.practice.thesportdbadvance.di

import androidx.lifecycle.ViewModel
import com.practice.thesportdbadvance.teamlist.TeamListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TeamListViewModel::class)
    internal abstract fun bindTeamListViewModel(viewModel: TeamListViewModel): ViewModel
}