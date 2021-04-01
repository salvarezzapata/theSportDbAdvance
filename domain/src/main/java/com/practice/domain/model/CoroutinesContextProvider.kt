package com.practice.domain.model

import kotlin.coroutines.CoroutineContext

data class CoroutinesContextProvider(
    val mainContext: CoroutineContext,
    val backgroundContext: CoroutineContext
)