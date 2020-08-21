package com.otb.analyticssdk

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Mohit Rajput on 21/8/2020.
 */
class AnalyticsUtils {
    companion object {
        /**
         * Converts a boolean to string with "Yes" and "No".
         */
        fun getFormattedBoolean(value: Boolean) = if (value) "Yes" else "No"

        /**
         * Returns current date in UTC
         */
        fun getUtcDate(): String {
            val dateNow = Date()
            val calendar = Calendar.getInstance()
            calendar.timeZone = TimeZone.getTimeZone("UTC")
            calendar.time = dateNow
            val time = calendar.time
            val outputFmt = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
            outputFmt.timeZone = TimeZone.getTimeZone("UTC")
            return outputFmt.format(time)
        }

        /**
         * Format date to DD/MM/YYYY format
         */
        fun getFormattedDate(date: Date): String = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(date)
    }
}