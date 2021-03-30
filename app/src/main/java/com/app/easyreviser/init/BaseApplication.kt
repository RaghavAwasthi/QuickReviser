package com.app.easyreviser.init

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}