package com.otb.analyticsexample

import android.app.Application
import com.otb.analyticsexample.common.GoogleAnalyticsTracker
import com.otb.analyticsexample.common.MixpanelAnalyticsTracker
import com.otb.analyticsexample.example.SetupEvents
import com.otb.analyticssdk.DefaultAnalyticsService

/**
 * Created by Mohit Rajput on 21/8/20.
 */
class AnalyticsApplication : Application() {
    companion object {
        val analyticsService = DefaultAnalyticsService()
    }

    override fun onCreate() {
        super.onCreate()
        registerTracker()
        SetupEvents().trackEnvironment()
    }

    private fun registerTracker() {
        val trackers = listOf(MixpanelAnalyticsTracker(this), GoogleAnalyticsTracker(this))
        trackers.forEach { analyticsService.registerTracker(it) }
    }
}