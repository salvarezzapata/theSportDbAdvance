package com.practice.data.di

import com.practice.data.network.SportService
import com.practice.data.repository.RetrofitTeamRepository
import com.practice.domain.repository.remote.RemoteTeamRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [ServiceProviderModule::class]
)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRetrofitTeamRepository(sportService: SportService): RemoteTeamRepository {
        return RetrofitTeamRepository(sportService)
    }
}