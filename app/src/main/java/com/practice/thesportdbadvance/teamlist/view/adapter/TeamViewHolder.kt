package com.practice.thesportdbadvance.teamlist.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.practice.thesportdbadvance.R
import com.practice.thesportdbadvance.databinding.ItemTeamBinding
import com.practice.thesportdbadvance.model.ViewTeam

class TeamViewHolder(private val rowBinding: ItemTeamBinding) : RecyclerView.ViewHolder(rowBinding.root) {

    fun bind(team: ViewTeam) {
        Glide.with(rowBinding.root.context).load(team.strTeamBadge).placeholder(R.drawable.broken_image).into(rowBinding.ivTeamItem)
        rowBinding.tvTeamNameItem.text = team.strTeam
        rowBinding.tvStadiumName.text = team.strStadium
    }

}