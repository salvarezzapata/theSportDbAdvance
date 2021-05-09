package com.practice.thesportdbadvance

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.practice.domain.model.Team
import com.practice.thesportdbadvance.teamlist.TeamListViewModel
import com.practice.thesportdbadvance.utils.TestCoroutineRule
import com.practice.usecase.GetTeamsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class TeamListViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get: Rule
    private val coroutineRule = TestCoroutineRule()

    private val getTeamsUseCase: GetTeamsUseCase = mockk(relaxed = true)

    private val league: String = "league"

    private val team = Team(
        idTeam = "12w",
        strTeam = "team",
        intFormedYear = "1994",
        strStadium = "Atanasio Girardot",
        strWebsite = "www.google.com",
        strFacebook = "facebook-pecue",
        strTwitter = "twitter",
        strInstagram = "Insta",
        strDescriptionEN = "Description",
        strTeamBadge = "Badge",
        strTeamJersey = "Jersey",
        strYoutube = "youtube"
    )
    private val teams: List<Team> = listOf(team)
    private val teamsFlow: Flow<List<Team>> = flowOf(teams)

    private val teamListViewModel = TeamListViewModel(coroutineRule.coroutineContextProvider, getTeamsUseCase)

    init {
        coEvery {
            getTeamsUseCase.invoke(league)
        } answers {
            teamsFlow
        }
    }

    @Test
    fun myFirstViewModelTest() {
        Assert.assertTrue(teamListViewModel.stateFlowList.value is TeamListScreenState.Loading)
        //teamListViewModel.getTeams(league)
        //Assert.assertTrue(teamListViewModel.stateFlowList.value is TeamListScreenState.Success)
    }
}