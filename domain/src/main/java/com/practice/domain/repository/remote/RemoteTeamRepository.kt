package com.practice.domain.repository.remote

import com.practice.domain.model.Team
import kotlinx.coroutines.flow.Flow

interface RemoteTeamRepository {

    fun getTeams(league: String): Flow<List<Team>>

    suspend fun getTeam(teamId: String): Team
}