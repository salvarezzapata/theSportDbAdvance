package com.practice.domain.repository.remote

import com.practice.domain.model.League

interface RemoteLeagueRepository {

    suspend fun getLeagues(): List<League>
}