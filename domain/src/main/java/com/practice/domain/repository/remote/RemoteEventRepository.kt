package com.practice.domain.repository.remote

import com.practice.domain.model.Event

interface RemoteEventRepository {

    suspend fun getEvents(teamId: String): List<Event>
}