package com.practice.thesportdbadvance.model

abstract class ScreenLoader {

    fun show() {
        if(isConfigurationOn()) {
            showLoader()
        } else {
            throw RuntimeException("You must configure ScreenLoader")
        }
    }

    fun hide() {
        if(isConfigurationOn()) {
            hideLoader()
        } else {
            throw RuntimeException("You must configure ScreenLoader")
        }
    }

    protected abstract fun isConfigurationOn(): Boolean
    protected abstract fun showLoader()
    protected abstract fun hideLoader()
}