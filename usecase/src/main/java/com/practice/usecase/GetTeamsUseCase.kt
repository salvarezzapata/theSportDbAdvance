package com.practice.usecase

import com.practice.domain.model.Team
import com.practice.domain.repository.remote.RemoteTeamRepository
import javax.inject.Inject

class GetTeamsUseCase @Inject constructor(private val remoteTeamRepository: RemoteTeamRepository) {

    suspend fun invoke(league: String): List<Team> {
        return remoteTeamRepository.getTeams(league)
    }
}