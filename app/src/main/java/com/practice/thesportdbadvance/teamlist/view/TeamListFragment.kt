package com.practice.thesportdbadvance.teamlist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.practice.thesportdbadvance.databinding.FragmentTeamListBinding
import com.practice.thesportdbadvance.model.RecyclerViewLoader
import com.practice.thesportdbadvance.model.ScreenLoader
import com.practice.thesportdbadvance.teamlist.view.adapter.TeamAdapter
import com.practice.thesportdbadvance.teamlist.TeamListViewModel
import dagger.android.support.DaggerFragment

import javax.inject.Inject

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TeamListFragment : DaggerFragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var screenLoader: ScreenLoader

    private lateinit var binding: FragmentTeamListBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val teamListViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(TeamListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
        teamListViewModel.teamsLiveData.observe(viewLifecycleOwner, Observer {
            val adapter = TeamAdapter(it)
            binding.rvTeams.adapter = adapter
        })

        teamListViewModel.loadingLiveData.observe(viewLifecycleOwner, Observer {
            if(it) {
                screenLoader.show()
            } else {
                screenLoader.hide()
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TeamListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}