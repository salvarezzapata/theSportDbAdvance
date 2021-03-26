package com.practice.data.repository

import com.practice.data.model.APITeam
import com.practice.data.network.SportService
import com.practice.domain.model.Team
import com.practice.domain.repository.remote.RemoteTeamRepository
import javax.inject.Inject

class RetrofitTeamRepository @Inject constructor(private val sportService: SportService) : RemoteTeamRepository {

    override suspend fun getTeams(league: String): List<Team> {
        return sportService.getTeams(league).apiTeams.map {
                apiTeam: APITeam -> apiTeam.apiTeamToTeam()
        }
    }

    override suspend fun getTeam(teamId: String): Team {
        return sportService.getTeam(teamId).apiTeam.apiTeamToTeam()
    }
}