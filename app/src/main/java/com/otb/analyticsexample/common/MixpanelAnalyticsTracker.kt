package com.otb.analyticsexample.common

import android.content.Context
import com.google.gson.Gson
import com.mixpanel.android.mpmetrics.MixpanelAPI
import com.otb.analyticssdk.*
import org.json.JSONArray

/**
 * Created by Mohit Rajput on 21/8/2020.
 */
internal class MixpanelAnalyticsTracker(context: Context) : AnalyticsTracker {
    private val mixpanel: MixpanelAPI = MixpanelAPI.getInstance(context, "<PLACE_MIXPANEL_TOKEN>")

    override fun trackSuperProperties(analyticsProperty: AnalyticsProperty) {
        mixpanel.registerSuperPropertiesMap(analyticsProperty.properties)
    }

    override fun trackUser(user: AnalyticsUser) {
        if (user.isNewUser) {
            mixpanel.alias(user.identifier, mixpanel.distinctId)
        }
        mixpanel.identify(user.identifier)
        mixpanel.people.identify(user.identifier)
    }

    override fun trackUserProperties(analyticsProperty: AnalyticsProperty) {
        if (analyticsProperty.hasSystemProperties) {
            val properties = HashMap<String, Any>()
            properties.putAll(analyticsProperty.properties)
            val iterator = (analyticsProperty.properties as HashMap<String, Any>).iterator()
            while (iterator.hasNext()) {
                val entry = iterator.next()
                when (entry.key) {
                    SystemProperty.FirstName.propertyName -> {
                        properties["\$first_name"] = properties[entry.key] as Any
                        properties.remove(entry.key)
                    }
                    SystemProperty.LastName.propertyName -> {
                        properties["\$last_name"] = properties[entry.key] as Any
                        properties.remove(entry.key)
                    }
                    SystemProperty.Email.propertyName -> {
                        properties["\$email"] = properties[entry.key] as Any
                        properties.remove(entry.key)
                    }
                    SystemProperty.AndroidDevices.propertyName -> {
                        properties["\$android_devices"] = properties[entry.key] as Any
                        properties.remove(entry.key)
                    }
                }
            }
            mixpanel.people.setMap(properties)
        } else {
            mixpanel.people.setMap(analyticsProperty.properties)
        }
    }

    override fun trackUserPropertiesUnion(analyticsUnionProperty: AnalyticsUnionProperty) {
        mixpanel.people.union(
            analyticsUnionProperty.key,
            JSONArray(Gson().toJson(analyticsUnionProperty.values))
        )
    }

    override fun trackUserPropertiesOnce(analyticsProperty: AnalyticsProperty) {
        mixpanel.people.setOnceMap(analyticsProperty.properties)
    }

    override fun incrementUserProperty(analyticsIncrement: AnalyticsIncrement) {
        mixpanel.people.increment(analyticsIncrement.name, analyticsIncrement.countToIncrement)
    }

    override fun trackEvent(event: AnalyticsEvent) {
        mixpanel.trackMap(event.name, event.properties)
    }

    override fun clear() {
        mixpanel.flush()
        mixpanel.reset()
    }
}