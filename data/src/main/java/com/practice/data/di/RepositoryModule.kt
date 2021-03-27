package com.practice.data.di

import com.practice.data.repository.RetrofitTeamRepository
import com.practice.domain.repository.remote.RemoteTeamRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(
    includes = [ServiceProviderModule::class]
)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun provideRetrofitTeamRepository(retrofitRepository: RetrofitTeamRepository): RemoteTeamRepository
}