package com.practice.data.repository

import com.practice.data.model.APIEvent
import com.practice.data.network.SportService
import com.practice.domain.model.Event
import com.practice.domain.repository.remote.RemoteEventRepository

class RetrofitEventRepository(private val sportService: SportService) : RemoteEventRepository {

    override suspend fun getEvents(teamId: String): List<Event> {
        return sportService.getEvents(teamId).apiEvents.map { apiEvent: APIEvent ->
            apiEvent.apiEventToEvent()
        }
    }
}