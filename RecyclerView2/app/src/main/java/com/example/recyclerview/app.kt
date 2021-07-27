package com.example.recyclerview

import android.app.Application

class app : Application() {

    companion object {
        lateinit var instance: app
        private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}