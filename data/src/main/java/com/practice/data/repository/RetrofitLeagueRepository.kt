package com.practice.data.repository

import com.practice.data.model.APILeague
import com.practice.data.network.SportService
import com.practice.domain.model.League
import com.practice.domain.repository.remote.RemoteLeagueRepository

class RetrofitLeagueRepository(private val sportService: SportService) : RemoteLeagueRepository {

    override suspend fun getLeagues(): List<League> {
        return sportService.getLeagues().apiLeagues.map { apiLeague: APILeague ->
            apiLeague.apiLeagueToLeague()
        }
    }
}