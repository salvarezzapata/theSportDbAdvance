package com.practice.usecase

import com.practice.domain.model.Team
import com.practice.domain.repository.remote.RemoteTeamRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetTeamsUseCase @Inject constructor(private val remoteTeamRepository: RemoteTeamRepository) {

    fun invoke(league: String): Flow<List<Team>> {
        return remoteTeamRepository.getTeams(league)
    }
}