package com.otb.analyticsexample.example

import com.otb.analyticsexample.AnalyticsApplication
import com.otb.analyticssdk.AnalyticsEvent
import com.otb.analyticssdk.AnalyticsIncrement
import com.otb.analyticssdk.AnalyticsProperty
import com.otb.analyticssdk.AnalyticsUtils

/**
 * Created by Mohit Rajput on 24/8/2020.
 */
class LoginEvents {
    fun trackLogin() {
        AnalyticsApplication.analyticsService.trackEvent(AnalyticsEvent("log in"))

        val userOnceProps = HashMap<String, Any>()
        userOnceProps["First login"] = AnalyticsUtils.getUtcDate()
        AnalyticsApplication.analyticsService.trackUserPropertiesOnce(AnalyticsProperty(userOnceProps))

        val userProps = HashMap<String, Any>()
        userProps["Last login"] = AnalyticsUtils.getUtcDate()
        AnalyticsApplication.analyticsService.trackUserProperties(AnalyticsProperty(userProps))

        AnalyticsApplication.analyticsService.incrementUserProperty(AnalyticsIncrement("# of logins", 1.toDouble()))
    }

    fun trackForgotPassword() {
        AnalyticsApplication.analyticsService.trackEvent(AnalyticsEvent("forgot password"))

        val userProps = HashMap<String, Any>()
        userProps["Last password reset"] = AnalyticsUtils.getUtcDate()
        AnalyticsApplication.analyticsService.trackUserProperties(AnalyticsProperty(userProps))

        AnalyticsApplication.analyticsService.incrementUserProperty(AnalyticsIncrement("# of passcode resets", 1.toDouble()))
    }

    fun trackLogout() {
        AnalyticsApplication.analyticsService.trackEvent(AnalyticsEvent("log out"))

        val userProps = HashMap<String, Any>()
        userProps["Last log out"] = AnalyticsUtils.getUtcDate()
        AnalyticsApplication.analyticsService.trackUserProperties(AnalyticsProperty(userProps))

        AnalyticsApplication.analyticsService.incrementUserProperty(AnalyticsIncrement("# of log outs", 1.toDouble()))
        AnalyticsApplication.analyticsService.clear()

        SetupEvents().trackEnvironment()
    }
}