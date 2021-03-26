package com.practice.data.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.practice.domain.model.Team

data class APITeamsResponse(@SerializedName("teams") val apiTeams: List<APITeam>)

data class APITeamResponse(val apiTeam: APITeam)

data class APITeam(
    @SerializedName("idTeam")
    val idTeam: String,
    @SerializedName("strTeam")
    val strTeam: String,
    @SerializedName("intFormedYear")
    val intFormedYear: String,
    @SerializedName("strStadium")
    val strStadium: String,
    @SerializedName("strWebsite")
    val strWebsite: String? = null,
    @SerializedName("strFacebook")
    val strFacebook: String? = null,
    @SerializedName("strTwitter")
    val strTwitter: String? = null,
    @SerializedName("strInstagram")
    val strInstagram: String? = null,
    @SerializedName("strDescriptionEN")
    val strDescriptionEN: String? = null,
    @SerializedName("strTeamBadge")
    val strTeamBadge: String? = null,
    @SerializedName("strTeamJersey")
    val strTeamJersey: String? = null,
    @SerializedName("strYoutube")
    val strYoutube: String? = null
) {
    fun  apiTeamToTeam(): Team {
        val gsonConverter = Gson()
        val strApiTeam = gsonConverter.toJson(this)
        return gsonConverter.fromJson(strApiTeam, Team::class.java)
    }
}