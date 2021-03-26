package com.practice.domain.repository.remote

import com.practice.domain.model.Team

interface RemoteTeamRepository {

    suspend fun getTeams(league: String): List<Team>

    suspend fun getTeam(teamId: String): Team
}