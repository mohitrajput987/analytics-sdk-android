package com.otb.analyticssdk

/**
 * Created by Mohit Rajput on 21/8/2020.
 */
interface AnalyticsService : AnalyticsTracker {
    fun registerTracker(analyticsTracker: AnalyticsTracker)
}