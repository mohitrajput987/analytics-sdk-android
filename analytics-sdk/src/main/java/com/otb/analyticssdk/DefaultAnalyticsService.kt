package com.otb.analyticssdk

/**
 * Created by Mohit Rajput on 29/8/19.
 * Generic class to track analytics events of all implementations of #AnalyticsTracker
 * @see AnalyticsTracker
 */
class DefaultAnalyticsService : AnalyticsService {
    private val trackers = mutableListOf<AnalyticsTracker>()

    override fun registerTracker(analyticsTracker: AnalyticsTracker) {
        trackers.add(analyticsTracker)
    }

    override fun trackUser(user: AnalyticsUser) {
        trackers.forEach { it.trackUser(user) }
    }

    override fun trackUserProperties(analyticsProperty: AnalyticsProperty) {
        trackers.forEach { it.trackUserProperties(analyticsProperty) }
    }

    override fun trackUserPropertiesUnion(analyticsUnionProperty: AnalyticsUnionProperty) {
        trackers.forEach { it.trackUserPropertiesUnion(analyticsUnionProperty) }
    }

    override fun trackUserPropertiesOnce(analyticsProperty: AnalyticsProperty) {
        trackers.forEach { it.trackUserPropertiesOnce(analyticsProperty) }
    }

    override fun trackEvent(event: AnalyticsEvent) {
        trackers.forEach { it.trackEvent(event) }
    }

    override fun trackSuperProperties(analyticsProperty: AnalyticsProperty) {
        trackers.forEach { it.trackSuperProperties(analyticsProperty) }
    }

    override fun incrementUserProperty(analyticsIncrement: AnalyticsIncrement) {
        trackers.forEach { it.incrementUserProperty(analyticsIncrement) }
    }

    override fun clear() {
        trackers.forEach { it.clear() }
    }
}