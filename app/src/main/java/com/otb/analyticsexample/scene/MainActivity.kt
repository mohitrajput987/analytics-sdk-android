package com.otb.analyticsexample.scene

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.otb.analyticsexample.R
import com.otb.analyticsexample.example.LoginEvents
import com.otb.analyticsexample.example.SetupEvents
import com.otb.analyticsexample.model.User

class MainActivity : AppCompatActivity() {
    private val setupEvents = SetupEvents()
    private val loginEvents = LoginEvents()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        val user = User("ehgyl45jdh8sn94", "Mohit", "Rajput", "mohitrajput987@gmail.com", true)
        setupEvents.trackUser(user)
    }

    private fun onSuccessfulLogin() {
        loginEvents.trackLogin()
    }

    private fun onLogout() {
        loginEvents.trackLogout()
    }
}