package com.practice.data.repository

import com.practice.data.model.APITeam
import com.practice.data.network.SportService
import com.practice.domain.model.Team
import com.practice.domain.repository.remote.RemoteTeamRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RetrofitTeamRepository @Inject constructor(private val sportService: SportService) : RemoteTeamRepository {

    override fun getTeams(league: String): Flow<List<Team>> {
        try {
            return flow {
                val teams: List<Team> = sportService.getTeams(league).apiTeams.map {
                        apiTeam: APITeam -> apiTeam.apiTeamToTeam()
                }
                emit(teams)
            }
        } catch (exception: Exception) {
            throw exception
        }
    }

    override suspend fun getTeam(teamId: String): Team {
        return sportService.getTeam(teamId).apiTeam.apiTeamToTeam()
    }
}