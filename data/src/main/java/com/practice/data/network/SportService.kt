package com.practice.data.network

import com.practice.data.model.APIEventsResponse
import com.practice.data.model.APILeaguesResponse
import com.practice.data.model.APITeamResponse
import com.practice.data.model.APITeamsResponse
import com.practice.data.util.EVENTS
import com.practice.data.util.SEARCH_ALL_TEAMS
import com.practice.data.util.LEAGUE_PARAMETER
import com.practice.data.util.TEAM
import com.practice.data.util.TEAM_ID_PARAMETER
import retrofit2.http.GET
import retrofit2.http.Query

interface SportService {

    @GET(SEARCH_ALL_TEAMS)
    suspend fun getLeagues(): APILeaguesResponse

    @GET(SEARCH_ALL_TEAMS)
    suspend fun getTeams(@Query(LEAGUE_PARAMETER) league: String): APITeamsResponse

    @GET(TEAM)
    suspend fun getTeam(@Query(TEAM_ID_PARAMETER) teamId: String): APITeamResponse

    @GET(EVENTS)
    suspend fun getEvents(@Query(TEAM_ID_PARAMETER) teamId: String): APIEventsResponse
}