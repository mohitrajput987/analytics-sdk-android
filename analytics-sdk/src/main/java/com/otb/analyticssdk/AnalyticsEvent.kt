package com.otb.analyticssdk

/**
 * Created by Mohit Rajput on 21/8/2020.
 */
data class AnalyticsEvent(
    val name: String,
    val properties: Map<String, Any> = HashMap()
)

data class AnalyticsUser(
    val identifier: String,
    val isNewUser: Boolean = false
)

data class AnalyticsUnionProperty(
    val key: String,
    val values: List<Any>
)

data class AnalyticsProperty(
    val properties: Map<String, Any>,
    val hasSystemProperties: Boolean = false
)

data class AnalyticsIncrement(
    val name: String,
    val countToIncrement: Double
)


enum class SystemProperty(var propertyName: String) {
    FirstName("\$system.firstName"),
    LastName("\$system.lastName"),
    Email("\$system.email"),
    AndroidDevices("\$system.android_devices")
}