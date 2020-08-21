package com.otb.analyticsexample.common

import android.content.Context
import com.google.android.gms.analytics.GoogleAnalytics
import com.google.android.gms.analytics.Tracker
import com.otb.analyticssdk.*

/**
 * Created by Mohit Rajput on 21/8/2020.
 */
internal class GoogleAnalyticsTracker(context: Context) : AnalyticsTracker {
    private val tracker: Tracker =
        GoogleAnalytics.getInstance(context).newTracker("<PLACE_GA_TRACKING_ID>")

    init {
        tracker.enableExceptionReporting(true)
    }

    override fun trackSuperProperties(analyticsProperty: AnalyticsProperty) {
    }

    override fun trackUser(user: AnalyticsUser) {
    }

    override fun trackUserProperties(analyticsProperty: AnalyticsProperty) {
    }

    override fun trackUserPropertiesUnion(analyticsUnionProperty: AnalyticsUnionProperty) {
    }

    override fun trackUserPropertiesOnce(analyticsProperty: AnalyticsProperty) {
    }

    override fun incrementUserProperty(analyticsIncrement: AnalyticsIncrement) {
    }

    override fun trackEvent(event: AnalyticsEvent) {
    }

    override fun clear() {
    }
}