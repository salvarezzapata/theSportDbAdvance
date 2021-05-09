package com.practice.thesportdbadvance.teamlist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.practice.thesportdbadvance.TeamListScreenState
import com.practice.thesportdbadvance.databinding.FragmentTeamListBinding
import com.practice.thesportdbadvance.model.RecyclerViewLoader
import com.practice.thesportdbadvance.model.ScreenLoader
import com.practice.thesportdbadvance.teamlist.view.adapter.TeamAdapter
import com.practice.thesportdbadvance.teamlist.TeamListViewModel
import dagger.android.support.DaggerFragment

import javax.inject.Inject
import kotlinx.coroutines.flow.collect

class TeamListFragment : DaggerFragment() {

    private lateinit var screenLoader: ScreenLoader

    private lateinit var binding: FragmentTeamListBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val teamListViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(TeamListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTeamListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        screenLoader = RecyclerViewLoader(binding.rvTeams)
        teamListViewModel.getTeams("English Premier League")
        executeObservables()
    }

    private fun executeObservables() {
        lifecycleScope.launchWhenResumed {
            teamListViewModel.stateFlowList.collect { screenState: TeamListScreenState ->
                when (screenState) {
                    is TeamListScreenState.Loading -> {
                        screenLoader.show()
                    }

                    is TeamListScreenState.Success.TeamsLoaded -> {
                        screenLoader.hide()
                        val adapter = TeamAdapter(screenState.viewTeams)
                        binding.rvTeams.adapter = adapter
                    }

                    is TeamListScreenState.Success.EmptyTeams -> {
                        screenLoader.hide()
                        val adapter = TeamAdapter(screenState.viewTeams)
                        binding.rvTeams.adapter = adapter
                    }

                    is TeamListScreenState.Error -> {
                        screenLoader.hide()
                    }
                }
            }
        }
    }
}