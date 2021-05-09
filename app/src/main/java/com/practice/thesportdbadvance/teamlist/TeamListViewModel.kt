package com.practice.thesportdbadvance.teamlist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.domain.model.CoroutinesContextProvider
import com.practice.domain.model.Team
import com.practice.thesportdbadvance.TeamListScreenState
import com.practice.thesportdbadvance.model.ViewTeam
import com.practice.usecase.GetTeamsUseCase
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class TeamListViewModel @Inject constructor(
    private val coroutinesContextProvider: CoroutinesContextProvider,
    private val getTeamsUseCase: GetTeamsUseCase
) : ViewModel() {

    val stateFlowList: MutableStateFlow<TeamListScreenState> = MutableStateFlow(TeamListScreenState.Loading)

    fun getTeams(league: String) {
        try {
            getTeamsUseCase.invoke(league).map { teams: List<Team> ->
                stateFlowList.value = TeamListScreenState.Success.TeamsLoaded(
                    teams.map {
                        ViewTeam(it)
                    }
                )
            }.onStart {
                stateFlowList.value = TeamListScreenState.Loading
            }.flowOn(coroutinesContextProvider.backgroundContext)
            .launchIn(viewModelScope)
        } catch (exception: Exception) {
            stateFlowList.value = TeamListScreenState.Error(exception)
            Log.e("myerror", exception.message!!)
        }
    }
}