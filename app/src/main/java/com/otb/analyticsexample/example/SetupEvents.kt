package com.otb.analyticsexample.example

import com.mixpanel.android.BuildConfig
import com.otb.analyticsexample.AnalyticsApplication
import com.otb.analyticsexample.model.User
import com.otb.analyticssdk.AnalyticsProperty
import com.otb.analyticssdk.AnalyticsUser
import com.otb.analyticssdk.SystemProperty

/**
 * Created by Mohit Rajput on 24/8/20.
 */
class SetupEvents {
    fun trackEnvironment() {
        val superProps = HashMap<String, Any>()
        superProps["Environment"] = getBuildEnvironment()
        AnalyticsApplication.analyticsService.trackSuperProperties(AnalyticsProperty(superProps))
    }

    fun trackUser(user: User) {
        AnalyticsApplication.analyticsService.trackUser(AnalyticsUser(user.id, user.isNewUser))

        val userProperties = HashMap<String, Any>()
        userProperties[SystemProperty.FirstName.propertyName] = user.firstName
        userProperties[SystemProperty.LastName.propertyName] = user.lastName
        userProperties[SystemProperty.Email.propertyName] = user.email
        userProperties["Unique user identifier"] = user.id
        AnalyticsApplication.analyticsService.trackUserProperties(AnalyticsProperty(userProperties, true))
    }

    private fun getBuildEnvironment(): String {
        return when (BuildConfig.FLAVOR) {
            "dev" -> "development"
            "qa" -> "test"
            "staging" -> "staging"
            "prod" -> "production"
            else -> ""
        }
    }
}