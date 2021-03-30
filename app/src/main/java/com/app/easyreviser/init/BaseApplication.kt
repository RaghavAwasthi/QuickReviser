package com.app.easyreviser.init

import android.app.Application
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.app.easyreviser.repository.CardWorker
import com.jakewharton.threetenabp.AndroidThreeTen
import java.util.concurrent.TimeUnit

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)

    }
}