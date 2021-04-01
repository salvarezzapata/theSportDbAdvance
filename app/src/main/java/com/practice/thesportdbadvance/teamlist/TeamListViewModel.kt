package com.practice.thesportdbadvance.teamlist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.domain.model.CoroutinesContextProvider
import com.practice.thesportdbadvance.model.ViewTeam
import com.practice.usecase.GetTeamsUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

class TeamListViewModel @Inject constructor(private val coroutinesContextProvider: CoroutinesContextProvider,private val getTeamsUseCase: GetTeamsUseCase) : ViewModel() {

    val teamsLiveData: MutableLiveData<List<ViewTeam>> by lazy {
        MutableLiveData<List<ViewTeam>>()
    }

    val loadingLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun getTeams(league: String) {
        viewModelScope.launch {
            try {
                getTeamsUseCase.invoke(league)
                    .onStart {
                        loadingLiveData.postValue(true)
                    }
                    .onCompletion {
                        loadingLiveData.postValue(false)
                    }
                    .flowOn(coroutinesContextProvider.backgroundContext)
                    .collect {teams ->
                        teamsLiveData.postValue(teams.map {
                            ViewTeam(it)
                        })
                    }
            } catch (exception: Exception) {
                loadingLiveData.value = false
                Log.e("myerror", exception.message!!)
            }
        }
    }
}