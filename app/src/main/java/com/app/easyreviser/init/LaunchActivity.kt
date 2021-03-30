package com.app.easyreviser.init

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.app.easyreviser.MainActivity
import com.app.easyreviser.repository.AppPreference
import com.app.easyreviser.repository.CardWorker
import com.app.easyreviser.repository.Constants
import java.util.concurrent.TimeUnit

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (AppPreference.getInstance(applicationContext).getBoolean(Constants.FIRSTLAUNCH, true)) {
            val request: WorkRequest =
                PeriodicWorkRequestBuilder<CardWorker>(24, TimeUnit.HOURS).build()
            WorkManager.getInstance(applicationContext).enqueue(request)
            val intent = Intent(this, IntroActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}