package com.practice.thesportdbadvance.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class TestCoroutineRule : TestRule {

    private val job = SupervisorJob()
    private val testCoroutineDispatcher = TestCoroutineDispatcher()

    override fun apply(base: Statement?, description: Description?): Statement {
        return object : Statement() {
            override fun evaluate() {
                Dispatchers.setMain(testCoroutineDispatcher)
                base?.evaluate()
                job.cancel()
                Dispatchers.resetMain()
            }
        }
    }
}