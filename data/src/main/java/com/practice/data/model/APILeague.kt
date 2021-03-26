package com.practice.data.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.practice.domain.model.League

data class APILeaguesResponse(val apiLeagues: List<APILeague>)

data class APILeague(
    @SerializedName("idLeague")
    val id: String,
    @SerializedName("strLeague")
    val leagueName: String,
    @SerializedName("strSport")
    val sport: String,
    @SerializedName("strLeagueAlternate")
    val leagueAlternate: String
) {
    fun apiLeagueToLeague(): League {
        return Gson().fromJson(Gson().toJson(this), League::class.java)

    }
}