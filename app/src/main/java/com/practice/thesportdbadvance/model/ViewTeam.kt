package com.practice.thesportdbadvance.model

import com.practice.domain.model.Team

data class ViewTeam(
    val idTeam: String,
    val strTeam: String,
    val intFormedYear: String,
    val strStadium: String,
    val strWebsite: String?,
    val strFacebook: String?,
    val strTwitter: String?,
    val strInstagram: String?,
    val strDescriptionEN: String,
    val strTeamBadge: String,
    val strTeamJersey: String?,
    val strYoutube: String?
) {
    constructor(team: Team) : this (
        team.idTeam,
        team.strTeam,
        team.intFormedYear,
        team.strStadium,
        team.strWebsite,
        team.strFacebook,
        team.strTwitter,
        team.strInstagram,
        team.strDescriptionEN,
        team.strTeamBadge,
        team.strTeamJersey,
        team.strYoutube
    )
}