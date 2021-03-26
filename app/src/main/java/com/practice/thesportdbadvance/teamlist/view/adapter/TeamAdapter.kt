package com.practice.thesportdbadvance.teamlist.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practice.thesportdbadvance.databinding.ItemTeamBinding
import com.practice.thesportdbadvance.model.ViewTeam

class TeamAdapter(private val teams: List<ViewTeam>) : RecyclerView.Adapter<TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemTeamBinding = ItemTeamBinding.inflate(inflater, parent, false)
        return TeamViewHolder(binding)
    }

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(teams[position])
    }
}