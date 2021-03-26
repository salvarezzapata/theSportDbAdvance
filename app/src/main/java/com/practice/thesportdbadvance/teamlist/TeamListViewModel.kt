package com.practice.thesportdbadvance.teamlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.domain.model.Team
import com.practice.thesportdbadvance.model.ViewTeam
import com.practice.usecase.GetTeamsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TeamListViewModel @Inject constructor(private val getTeamsUseCase: GetTeamsUseCase) : ViewModel() {

    val teamsLiveData: MutableLiveData<List<ViewTeam>> by lazy {
        MutableLiveData<List<ViewTeam>>()
    }

    val loadingLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }


    fun getTeams(league: String) {
        viewModelScope.launch {
            loadingLiveData.value = true
            val teams: List<Team> = withContext(Dispatchers.IO) {
                getTeamsUseCase.invoke(league)
            }
            loadingLiveData.value = false
            teamsLiveData.value = teams.map { ViewTeam(it) }
        }
    }
}