package com.otb.analyticssdk

/**
 * Created by Mohit Rajput on 21/8/2020.
 */
interface AnalyticsTracker {
    fun trackUser(user: AnalyticsUser)
    fun trackUserProperties(analyticsProperty: AnalyticsProperty)
    fun trackUserPropertiesUnion(analyticsUnionProperty: AnalyticsUnionProperty)
    fun trackUserPropertiesOnce(analyticsProperty: AnalyticsProperty)
    fun trackEvent(event: AnalyticsEvent)
    fun trackSuperProperties(analyticsProperty: AnalyticsProperty)
    fun incrementUserProperty(analyticsIncrement: AnalyticsIncrement)
    fun clear()
}

fun String.getScreenName(): String {
    return replace("Activity", "").replace("Fragment", "")
}