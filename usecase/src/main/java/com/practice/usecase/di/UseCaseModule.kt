package com.practice.usecase.di

import com.practice.data.di.RepositoryModule
import com.practice.data.repository.RetrofitTeamRepository
import com.practice.usecase.GetTeamsUseCase
import dagger.Module
import dagger.Provides

@Module(
    includes = [RepositoryModule::class]
)
class UseCaseModule {

    @Provides
    fun provideGetTeamsUseCase(repository: RetrofitTeamRepository): GetTeamsUseCase {
        return GetTeamsUseCase(repository)
    }
}