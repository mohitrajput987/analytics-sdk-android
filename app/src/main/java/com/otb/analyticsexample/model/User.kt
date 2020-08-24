package com.otb.analyticsexample.model

/**
 * Created by Mohit Rajput on 24/8/20.
 */
data class User(
        val id: String,
        val firstName: String,
        val lastName: String,
        val email: String,
        val isNewUser : Boolean = false
)