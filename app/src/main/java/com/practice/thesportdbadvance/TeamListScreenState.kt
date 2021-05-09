package com.practice.thesportdbadvance

import com.practice.thesportdbadvance.model.ViewTeam

sealed class TeamListScreenState {

    object Loading: TeamListScreenState()

    sealed class Success : TeamListScreenState() {
        data class TeamsLoaded(val viewTeams: List<ViewTeam>) : TeamListScreenState()
        data class EmptyTeams(val viewTeams: List<ViewTeam>) : TeamListScreenState()
    }

    data class Error(val exception: Exception) : TeamListScreenState()
}
