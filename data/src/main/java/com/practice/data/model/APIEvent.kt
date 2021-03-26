package com.practice.data.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.practice.domain.model.Event

data class APIEventsResponse(val apiEvents: List<APIEvent>)

data class APIEvent(
    @SerializedName("idEvent")
    val idEvent: String,
    @SerializedName("idTeam")
    val idTeam: String,
    @SerializedName("strEvent")
    val strEvent: String
) {
    fun apiEventToEvent() : Event {
        val gsonConverter = Gson()
        val strApiEvent = gsonConverter.toJson(this)
        return gsonConverter.fromJson(strApiEvent, Event::class.java)
    }
}